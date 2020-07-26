package Leetcode;

import java.util.*;

public class Leetcode_1086_high_five {
    public static int[][] highFive(int[][] items) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int[] tmp : items){
            if(!hm.containsKey(tmp[0])){
                hm.put(tmp[0], new ArrayList<>());
            }
            ArrayList<Integer> trtmp = hm.get(tmp[0]);
            trtmp.add(tmp[1]);
            hm.put(tmp[0], trtmp);
        }

        int[][] result = new int[hm.size()][2];
        Set set = hm.keySet();
        Iterator it = set.iterator();
        int pp = 0;
        while(it.hasNext()){
            int key_tmp = (int) it.next();
            result[pp][0] = key_tmp;
            Collections.sort(hm.get(key_tmp), Collections.reverseOrder());
            result[pp++][1] = (int) hm.get(key_tmp).stream().limit(5).mapToInt(Integer::intValue).average().orElse(0.0);
        }
        return result;

//        HashMap<Integer, ArrayList<Integer>> hm = new HashMap();
//        for(int i = 0; i < items.length; i++){
//            if(!hm.containsKey(items[i][0])){
//                ArrayList<Integer> tmp = new ArrayList<>();
//                tmp.add(items[i][1]);
//                hm.put(items[i][0], tmp);
//            } else {
//                ArrayList<Integer> tmp = hm.get(items[i][0]);
//                if(tmp.size() < 5){
//                    tmp.add(items[i][1]);
//                } else {
//                    if(items[i][1] > Collections.min(tmp)){
//                        tmp.remove(Collections.min(tmp));
//                        tmp.add(items[i][1]);
//                    }
//                }
//            }
//        }
//
//        int[][] result = new int[hm.size()][2];
//        Set set = hm.keySet();
//        Iterator it = set.iterator();
//        int pp = 0;
//        while(it.hasNext()){
//            int IntTmp = (int) it.next();
//            ArrayList<Integer> tmp = hm.get(IntTmp);
//            result[pp][0] = IntTmp;
//            result[pp++][1] = (int) tmp.stream().mapToInt(Integer::intValue).average().orElse(0.0);
//        }
//        return result;
    }

    public static void main(String[] args){
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] result = highFive(items);


//        PriorityQueue<Integer> aa = new PriorityQueue<>();
//        aa.add(91);
//        aa.add(92);
//        aa.add(60);
//        aa.add(65);
//        aa.add(87);
//        aa.add(100);
//
//        Iterator it = aa.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        aa.forEach(System.out::println);
//        System.out.println(aa.remove());
//        System.out.println(aa.remove());
//        System.out.println(aa.remove());
//        System.out.println(aa.remove());
//        System.out.println(aa.remove());

        for(int i = 0; i < result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
