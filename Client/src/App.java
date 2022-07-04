import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class App extends Thread {
    private Scanner netscan;
    private String handle;
    public static void main(String[] args) {
        new App();
    }

    public App() {
        try {
            Scanner keyscan = new Scanner( System.in );


            System.out.print( "サーバ IP (最後の数字): " );
            String addr = keyscan.nextLine();

            Socket sc = new Socket( "IPアドレス+ポート番号入力" );
            System.out.println( "サーバに接続されました" );

            PrintWriter pw = new PrintWriter( sc.getOutputStream(), true );
            this.netscan = new Scanner( sc.getInputStream() );

            this.start();

            while ( true ) {
                System.out.print( "入力: " );
                String mes = keyscan.nextLine();
                pw.println( this.handle + ": " + mes );
            }
        }
        catch ( Exception e ) {
            System.out.println("エラーが発生しました！");
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while ( true ) {
            String rec = this.netscan.nextLine();
            System.out.println( rec );
        }
    
    }
}
