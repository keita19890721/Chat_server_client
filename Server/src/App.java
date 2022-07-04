import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<ClientSupport> clist;
    public static void main(String[] args) {
        new App();
    }

    public App() {
        this.clist = new ArrayList<ClientSupport>();
        try {
            ServerSocket ss = new ServerSocket();
            ss.bind( new InetSocketAddress("IPアドレス入力", "ポート番号入力") );
    
            System.out.println( "サーバが起動されました" );

            while ( true ) {
                Socket sc = ss.accept();
                ClientSupport cs = new ClientSupport( this, sc );
                clist.add( cs );
                cs.start();
            }

        }
        catch ( Exception e ) {
            System.out.println("エラーが発生しました！");
        }
    }

    public void sendAll( String mes ) {
        for ( ClientSupport cs : clist ) {
            cs.send( mes );
        }
    }
}
