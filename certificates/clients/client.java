import java.net.*;
import java.io.*;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.security.KeyStore;
import java.security.cert.*;
import java.io.Console;

/*
 * This example shows how to set up a key manager to perform client
 * authentication.
 *
 * This program assumes that the client is not inside a firewall.
 * The application can be modified to connect to a server outside
 * the firewall by following SSLSocketClientWithTunneling.java.
 */

public class client {
  
  public static void main(String[] args) throws Exception {
    String host = null;
    int port = -1;
    for (int i = 0; i < args.length; i++) {
      System.out.println("args[" + i + "] = " + args[i]);
    }
    if (args.length < 2) {
      System.out.println("USAGE: java client host port");
      System.exit(-1);
    }
    try { /* get input parameters */
      host = args[0];
      port = Integer.parseInt(args[1]);
    } catch (IllegalArgumentException e) {
      System.out.println("USAGE: java client host port");
      System.exit(-1);
    }

    try {
      SSLSocketFactory factory = null;
      try {
        Console cons = System.console();
        System.out.println("Welcome to very good hospital system");
        System.out.println("Keystore name?");
        String keyStoreName = cons.readLine();
        System.out.println("Truststore name?");
        String trustStoreName = cons.readLine();
        System.out.println("Password?");
        char[] password = cons.readPassword();
        KeyStore keyStore = KeyStore.getInstance("JKS");
        KeyStore trustStore = KeyStore.getInstance("JKS");
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        SSLContext ctx = SSLContext.getInstance("TLSv1.2");
        // keystore password (storepass)
        try {
          keyStore.load(new FileInputStream("../" + keyStoreName), password);
          trustStore.load(new FileInputStream("../" + trustStoreName), password);
          kmf.init(keyStore, password);
          tmf.init(keyStore);
          ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
          factory = ctx.getSocketFactory();
        } catch (Exception e) {
          throw new IOException((e.getMessage()));
        }
      }
      catch (Exception e) {
        System.out.println("Wrong password, or not trusted");
        return;
      }
      SSLSocket socket = (SSLSocket)factory.createSocket(host, port);
      System.out.println("\nsocket before handshake:\n" + socket + "\n");

      /*
       * send http request
       *
       * See SSLSocketClient.java for more information about why
       * there is a forced handshake here when using PrintWriters.
       */

      socket.startHandshake();
      
      SSLSession session = socket.getSession();
      Certificate[] cert = session.getPeerCertificates();
      String subject = ((X509Certificate) cert[0]).getSubjectX500Principal().getName();
      System.out.println("certificate name (subject DN field) on certificate received from server:\n" + subject + "\n");
      System.out.println("socket after handshake:\n" + socket + "\n");
      System.out.println("secure connection established\n\n");

      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String msg;
      for (;;) {
        System.out.print(">");
        msg = read.readLine();
        if (msg.equalsIgnoreCase("quit")) {
          break;
        }
        System.out.print("sending '" + msg + "' to server...");
        out.println(msg);
        out.flush();
        System.out.println("done");
        System.out.println("received '" + in.readLine() + "' from server\n");
      }
      in.close();
      out.close();
      read.close();
      socket.close();
      }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}

