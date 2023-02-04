public class URLConnection {
    URL url = new URL("https://en.wikipedia.org");
    URLConnection connection = url.openConnection();
    connection.setRequestProperty("User-Agent","Revision Reporter/0.1 (nrhively@bsu.edu)");
    InputStream inputStream = connection.getInputStream();
}
