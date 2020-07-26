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

public class BinanceETH {
    public static void main(String[] args) throws IOException, ParseException {
        File fileOut = new File("e:\\FAU_laptop_backup\\E drive\\Backup\\2019 tax return\\8949\\output\\Binance_ETH_8949.csv");
        File file = new File("e:\\FAU_laptop_backup\\E drive\\Backup\\2019 tax return\\8949\\Binance_filled_ETH_import.csv");
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
        LinkedHashMap<Date, Double> bnbPrice = getBNBprice();
        LinkedHashMap<Date, Double> ethPrice = getETHprice();

        List<BinanceRecord> buyList = new ArrayList<>();
        List<BinanceRecord> sellList = new ArrayList<>();

        while((line = bufferedReader.readLine()) != null) {
            String[] wordArray = line.split(",");

            String temporalStr = wordArray[0].replace('T', ' ');
//            temporalStr = temporalStr.substring(0, temporalStr.length() -1 );
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(temporalStr);

            String dateStrTmp = wordArray[0].split(" ")[0];
            Date dateTmp = new SimpleDateFormat("yyyy-MM-dd").parse(dateStrTmp);
            Double btcPriceTmp = btcPrice.get(dateTmp);
            if(btcPriceTmp == null) {
                throw new RuntimeException("error: cannot get btc price!!!");
            }
            Double bnbPriceTmp = bnbPrice.get(dateTmp);
            if(bnbPriceTmp == null) {
                throw new RuntimeException("error: cannot get bnb price!!!");
            }
            Double ethPriceTmp = ethPrice.get(dateTmp);
            if(ethPriceTmp == null) {
                throw new RuntimeException("error: cannot get eth price!!!");
            }

            BinanceRecord binanceRecord = new BinanceRecord();
            binanceRecord.setTranDate(date);
            binanceRecord.setProduct(wordArray[1]);
            binanceRecord.setBuySell(wordArray[2]);
            binanceRecord.setSize(Double.parseDouble(wordArray[4]));
            binanceRecord.setFeeCoin(wordArray[7]);
            binanceRecord.setFee(Double.parseDouble(wordArray[6]) * bnbPriceTmp);
            if(wordArray[1].substring(wordArray[1].length() - 3).equals("BNB")) {
                binanceRecord.setPrice(Double.parseDouble(wordArray[3]) * bnbPriceTmp);
            } else if (wordArray[1].substring(wordArray[1].length() - 3).equals("BTC")) {
                binanceRecord.setPrice(Double.parseDouble(wordArray[3]) * btcPriceTmp);
            } else if (wordArray[1].substring(wordArray[1].length() - 3).equals("ETH")) {
                binanceRecord.setPrice(Double.parseDouble(wordArray[3]) * ethPriceTmp);
            } else {
                binanceRecord.setPrice(Double.parseDouble(wordArray[3]));
            }

//            System.out.println(record);
            if(binanceRecord.getBuySell().equals("BUY")) {
                buyList.add(binanceRecord);
            } else {
                sellList.add(binanceRecord);
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
                BinanceRecord curBuyRecord = buyList.get(i);
                double diff = sellSize - curBuyRecord.getSize();
                if(diff > 0) {
                    FinalRecord tmpRecord = new FinalRecord();
                    tmpRecord.setDescription(String.format("%f %s", curBuyRecord.getSize(), String.valueOf(curBuyRecord.getProduct()).substring(0, 3)));
                    tmpRecord.setDateAcquired(curBuyRecord.getTranDate());
                    tmpRecord.setDateSold(x.getTranDate());
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

    public static LinkedHashMap<Date, Double> getBNBprice() throws IOException, ParseException {
        File file = new File("e:\\FAU_laptop_backup\\E drive\\Backup\\2019 tax return\\8949\\BNB_price_daily.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int lineNum = 0;
        LinkedHashMap<Date, Double> bnbPrice = new LinkedHashMap<>();

        String line;
        line = bufferedReader.readLine();
        while((line = bufferedReader.readLine()) != null) {
            String[] wordArray = line.split(",");

            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(wordArray[0]);
            double price = Double.parseDouble(wordArray[4]);
            bnbPrice.put(date, price);

//            if(lineNum == 364) {
//                System.out.println("here it is");
//            }

            lineNum++;
        }

        if(lineNum > bnbPrice.size()) {
            throw new RuntimeException("error: BNB price history shorter than expected!");
        }
        return bnbPrice;
    }

    public static LinkedHashMap<Date, Double> getETHprice() throws IOException, ParseException {
        File file = new File("e:\\FAU_laptop_backup\\E drive\\Backup\\2019 tax return\\8949\\ETH_price_daily.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int lineNum = 0;
        LinkedHashMap<Date, Double> ethPrice = new LinkedHashMap<>();

        String line;
        line = bufferedReader.readLine();
        while((line = bufferedReader.readLine()) != null) {
            String[] wordArray = line.split(",");

            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(wordArray[0]);
            double price = Double.parseDouble(wordArray[4]);
            ethPrice.put(date, price);

//            if(lineNum == 364) {
//                System.out.println("here it is");
//            }

            lineNum++;
        }

        if(lineNum > ethPrice.size()) {
            throw new RuntimeException("error: ETH price history shorter than expected!");
        }
        return ethPrice;
    }
}




