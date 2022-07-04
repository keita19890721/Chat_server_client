import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSupport extends Thread {
    private App app;
    private Socket sc;
    private Scanner netscan;
    private PrintWriter pw;

    public ClientSupport( App app, Socket sc ) {
        try {
            this.app = app;
            this.sc = sc;
            this.netscan = new Scanner( sc.getInputStream() );
            this.pw = new PrintWriter( sc.getOutputStream(), true );
        }
        catch ( Exception e ) {
            System.out.println("エラーが発生しました");
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while ( true ) {
            String mes = this.netscan.nextLine();
            System.out.println( "クライアントから「" + mes + "」を受信しました。" );
            this.app.sendAll( mes );
        }

    }

    public void send( String mes ) {
        this.pw.println( mes );
    }
}
