package myClass;

public class Telegram {
    private String vid;
    private int countWord;
    public Telegram(String vid,int countWord ){
        this.vid=vid;
        this.countWord=countWord;
    }
    public int pudscht(){
        if(vid=="Международная") return countWord*5;//допусти 5
            if(vid=="Обычная") return countWord*2;
                if(vid=="Срочная") return countWord*4;
                return 0;
    }
}
