package TaxReturn;

import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class CoinbaseBTC {
    public static void main(String[] args) throws IOException, ParseException {
        File fileOut = new File("e:\\FAU_laptop_backup\\E drive\\Backup\\2019 tax return\\8949\\output\\Coinbase_BTC_8949.csv");
        File file = new File("e:\\FAU_laptop_backup\\E drive\\Backup\\2019 tax return\\8949\\Coinbase_filled_BTC_import.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int lineNum = 0;

        String line;
        line = bufferedReader.readLine();
        if(line.length() == 0) {
            throw new RuntimeException("Error: first line length is 0?");
        }

        LinkedHashMap<Date, Double> btcPrice = getBTCprice();

        List<Record> buyList = new ArrayList<>();
        List<Record> sellList = new ArrayList<>();

        while((line = bufferedReader.readLine()) != null) {
            String[] wordArray = line.split(",");

            String temporalStr = wordArray[4].replace('T', ' ');
            temporalStr = temporalStr.substring(0, temporalStr.length() -1 );
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssssss").parse(temporalStr);

            String dateStrTmp = wordArray[4].split("T")[0];
            Date dateTmp = new SimpleDateFormat("yyyy-MM-dd").parse(dateStrTmp);
            Double btcPriceTmp = btcPrice.get(dateTmp);
            if(btcPriceTmp == null) {
                throw new RuntimeException("error: cannot get btc price!!!");
            }

            Record record = new Record();
            record.setProduct(wordArray[2]);
            record.setBuySell(wordArray[3]);
            record.setTranDate(date);
            record.setSize(Double.parseDouble(wordArray[5]));
            if(wordArray[10].equals("BTC")) {
                record.setPrice(Double.parseDouble(wordArray[7]) * btcPriceTmp);
                record.setFee(Double.parseDouble(wordArray[8]) * btcPriceTmp);
                record.setTotal(Math.abs(Double.parseDouble(wordArray[9]) * btcPriceTmp));
            } else if (wordArray[10].equals("USD")) {
                record.setPrice(Double.parseDouble(wordArray[7]));
                record.setFee(Double.parseDouble(wordArray[8]));
                record.setTotal(Math.abs(Double.parseDouble(wordArray[9])));
            } else {
                System.out.println("Error: no such base!!");
                return;
            }

            record.setUnit(wordArray[10]);
            record.setBtcPrice(btcPriceTmp);

//            System.out.println(record);
            if(record.getBuySell().equals("BUY")) {
                buyList.add(record);
            } else {
                sellList.add(record);
            }

            lineNum++;
        }

        System.out.println("total line number is: " + lineNum);
//        System.out.println(buyList);
//        System.out.println(sellList);
        if(lineNum != buyList.size() + sellList.size()) {
            System.out.println("record number is not correct");
        }

        List<FinalRecord> finalRecordList = new ArrayList<>();

        sellList.forEach(x -> {
            double sellSize = x.getSize();
            for(int i = 0; i < buyList.size(); i++) {
                Record curBuyRecord = buyList.get(i);
                double diff = sellSize - curBuyRecord.getSize();
                if(diff > 0) {
                    FinalRecord tmpRecord = new FinalRecord();
                    tmpRecord.setDescription(String.format("%f %s", curBuyRecord.getSize(), String.valueOf(curBuyRecord.getProduct()).substring(0, 3)));
                    tmpRecord.setDateAcquired(curBuyRecord.getTranDate());
                    tmpRecord.setDateSold(x.getTranDate());
                    if(tmpRecord.getDateAcquired().compareTo(tmpRecord.getDateSold()) > 0) {
                        System.out.println("wrong");
                    }
                    tmpRecord.setProceeds(curBuyRecord.getSize() * x.getPrice());
                    tmpRecord.setCost(curBuyRecord.getSize() * curBuyRecord.getPrice());
                    tmpRecord.setGainOrLoss(tmpRecord.getProceeds() - tmpRecord.getCost());
                    finalRecordList.add(tmpRecord);

                    sellSize = sellSize - curBuyRecord.getSize();
                    buyList.remove(curBuyRecord);
                    i--;
//                    break;
                } else {
                    FinalRecord tmpRecord = new FinalRecord();
                    tmpRecord.setDescription(String.format("%f %s", sellSize, String.valueOf(x.getProduct()).substring(0, 3)));
                    tmpRecord.setDateAcquired(curBuyRecord.getTranDate());
                    tmpRecord.setDateSold(x.getTranDate());
                    if(tmpRecord.getDateAcquired().compareTo(tmpRecord.getDateSold()) > 0) {
                        System.out.println("wrong");
                    }
                    tmpRecord.setProceeds(sellSize * x.getPrice());
                    tmpRecord.setCost(sellSize * curBuyRecord.getPrice());
                    tmpRecord.setGainOrLoss(tmpRecord.getProceeds() - tmpRecord.getCost());
                    finalRecordList.add(tmpRecord);

                    if(diff == 0) {
                        buyList.remove(curBuyRecord);
                        i--;
                        break;
                    }
                    curBuyRecord.setSize(curBuyRecord.getSize() - sellSize);
                    break;
                }
            }
        });
//        System.out.println(finalRecordList);

//        -------------------- write to file ----------------------------------

        Writer fileWriter = new FileWriter(fileOut, false);

        finalRecordList.forEach(x -> {
            StringBuilder sb = new StringBuilder();

            DecimalFormat df1 = new DecimalFormat("#.##");
//            df1.setRoundingMode(RoundingMode.CEILING);

            DateFormat outAcquiredF = new SimpleDateFormat("MM/dd/yyyy");
            String dateAquiredStr = outAcquiredF.format(x.getDateAcquired());

            DateFormat outSoldF = new SimpleDateFormat("MM/dd/yyyy");
            String dateSoldStr = outSoldF.format(x.getDateSold());

            sb.append(x.getDescription()); sb.append(",");
            sb.append(dateAquiredStr); sb.append(",");
            sb.append(dateSoldStr); sb.append(",");
            sb.append(df1.format(x.getProceeds())); sb.append(",");
            sb.append(df1.format(x.getCost())); sb.append(",");
            sb.append(",");
            sb.append(",");
            sb.append(df1.format(x.getGainOrLoss()));

//            System.out.println(sb.toString());
            try {
                if(x.getProceeds() > 0.005) {
                    fileWriter.write(sb.toString());
                    fileWriter.write("\n");
                }
            } catch (IOException e) {
                System.out.println("file output error!!!!");
            }
        });
        fileWriter.close();
    }

    public static LinkedHashMap<Date, Double> getBTCprice() throws IOException, ParseException {
        File file = new File("e:\\FAU_laptop_backup\\E drive\\Backup\\2019 tax return\\8949\\BTC_price_daily.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int lineNum = 0;
        LinkedHashMap<Date, Double> btcPrice = new LinkedHashMap<>();

        String line;
        while((line = bufferedReader.readLine()) != null) {
            String[] wordArray = line.split(",");

            Date date = new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(wordArray[0]);
            double price = Double.parseDouble(wordArray[5]);
            btcPrice.put(date, price);

//            if(lineNum == 364) {
//                System.out.println("here it is");
//            }

            lineNum++;
        }

        if(lineNum > btcPrice.size()) {
            throw new RuntimeException("error: BTC price history shorter than expected!");
        }
        return btcPrice;
    }
}

//class Record {
//    private String product;
//    private String BuySell;
//    private Date tranDate;
//    private double size;
//    private double price;
//    private double fee;
//    private double total;
//    private String unit;
//    private double btcPrice;
//
//    public Record() {
//    }
//
////    public Record(String product, String buySell, Date tranDate, int size, double price, double fee, double total, String unit, double btcPrice) {
////        this.product = product;
////        BuySell = buySell;
////        this.tranDate = tranDate;
////        this.size = size;
////        this.price = price;
////        this.fee = fee;
////        this.total = total;
////        this.unit = unit;
////        this.btcPrice = btcPrice;
////    }
//
//    public String getProduct() {
//        return product;
//    }
//
//    public void setProduct(String product) {
//        this.product = product;
//    }
//
//    public String getBuySell() {
//        return BuySell;
//    }
//
//    public void setBuySell(String buySell) {
//        BuySell = buySell;
//    }
//
//    public Date getTranDate() {
//        return tranDate;
//    }
//
//    public void setTranDate(Date tranDate) {
//        this.tranDate = tranDate;
//    }
//
//    public double getSize() {
//        return size;
//    }
//
//    public void setSize(double size) {
//        this.size = size;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public double getFee() {
//        return fee;
//    }
//
//    public void setFee(double fee) {
//        this.fee = fee;
//    }
//
//    public double getTotal() {
//        return total;
//    }
//
//    public void setTotal(double total) {
//        this.total = total;
//    }
//
//    public String getUnit() {
//        return unit;
//    }
//
//    public void setUnit(String unit) {
//        this.unit = unit;
//    }
//
//    public double getBtcPrice() {
//        return btcPrice;
//    }
//
//    public void setBtcPrice(double btcPrice) {
//        this.btcPrice = btcPrice;
//    }
//
//    @Override
//    public String toString() {
//        return "Record{" +
//                "product='" + product + '\'' +
//                ", BuySell='" + BuySell + '\'' +
//                ", tranDate=" + tranDate +
//                ", size=" + size +
//                ", price=" + price +
//                ", fee=" + fee +
//                ", total=" + total +
//                ", unit='" + unit + '\'' +
//                ", btcPrice=" + btcPrice +
//                '}';
//    }
//}

//class FinalRecord {
//    private String description;
//    private Date dateAcquired;
//    private Date dateSold;
//    private double proceeds;
//    private double cost;
//    private double gainOrLoss;
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Date getDateAcquired() {
//        return dateAcquired;
//    }
//
//    public void setDateAcquired(Date dateAcquired) {
//        this.dateAcquired = dateAcquired;
//    }
//
//    public Date getDateSold() {
//        return dateSold;
//    }
//
//    public void setDateSold(Date dateSold) {
//        this.dateSold = dateSold;
//    }
//
//    public double getProceeds() {
//        return proceeds;
//    }
//
//    public void setProceeds(double proceeds) {
//        this.proceeds = proceeds;
//    }
//
//    public double getCost() {
//        return cost;
//    }
//
//    public void setCost(double cost) {
//        this.cost = cost;
//    }
//
//    public double getGainOrLoss() {
//        return gainOrLoss;
//    }
//
//    public void setGainOrLoss(double gainOrLoss) {
//        this.gainOrLoss = gainOrLoss;
//    }
//
//    @Override
//    public String toString() {
//        return "FinalRecord{" +
//                "description='" + description + '\'' +
//                ", dateAcquired=" + dateAcquired +
//                ", dateSold=" + dateSold +
//                ", proceeds=" + proceeds +
//                ", cost=" + cost +
//                ", gainOrLoss=" + gainOrLoss +
//                '}';
//    }
//}
