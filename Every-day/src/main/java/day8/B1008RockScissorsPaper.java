package day8;

import java.util.TreeMap;

public class B1008RockScissorsPaper {
    public static void main(String[] args) {

    }







    private static class Record{
        public int win;
        public int tie;
        public int lose;

        TreeMap<String,Integer> winCount;


        Record() {
            this.win = 0;
            this.tie = 0;
            this.lose = 0;

            this.winCount = new TreeMap<>();
            this.winCount.put("B",0);
            this.winCount.put("C",0);
            this.winCount.put("J",0);
        }
    }

    private static void win(Record[] records,int win, String gesture) {
        int lose =1 - win;
        records[win].win++;
        records[lose].lose++;


        int winCount = records[win].winCount.get(gesture);
        records[win].winCount.put(gesture,winCount + 1);

    }

    private static void judge(String a ,String b,Record[] records) {
        if(a.equals("B")) {
            if(b.equals("B")) {
                records[0].tie++;
                records[1].tie++;
            }else if(b.equals("C")) {
                win(records,0,"B");
            } else {
                win(records,1,"J");
            }
        } else if(a.equals("C")) {
            if(b.equals("B")) {
                win(records,1,"B");
            } else if(b.equals("C")) {
                records[0].tie++;
                records[1].tie++;
            }else  {
                win(records,0,"C");
            }

        } else {
            if(b.equals("B")) {
                win(records,0,"J");
            } else if(b.equals("C")) {
                win(records,1,"C");
            } else {
                records[0].tie++;
                records[1].tie++;
            }
        }
    }



























}
