package lq.study2;

public class Passenger {
    public static void main(String[] args) {
        Web c = new Web(4,"Train");
        new P(c,"lq1",2).start();
        new P(c,"lq2",3).start();
    }
}
class P extends Thread{
    int seats;
    public P(Runnable target,String name,int seats){
        super(target,name);
        this.seats= seats;
    }
}

class Web implements Runnable{
    int avail;
    String name;

    public Web(int avail, String name) {
        this.avail = avail;
        this.name = name;
    }
    @Override
    public void run() {
        P p = (P)Thread.currentThread();
        boolean flag = this.book(p.seats);
        if (flag){
            System.out.println("买表成功"+ Thread.currentThread().getName()+"位置为"+p.seats);
        }else {
            System.out.println("买表失败"+ Thread.currentThread().getName()+"可用票数为"+this.avail);
        }
    }

    private synchronized boolean book(int seats){
        System.out.println("可用的位置为" + avail);
        if (seats>avail){
            return false;
        }
        avail-=seats;
        return true;
    }
}
