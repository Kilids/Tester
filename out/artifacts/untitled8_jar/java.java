/*
 * Decompiled with CFR 0.152.
 */
package cfr;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import org.apache.commons.io.output.TeeOutputStream;
import org.benf.cfr.reader.Main;

public class Test {
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        TeeOutputStream teeStream = new TeeOutputStream(System.out, buffer);
        System.setOut(new PrintStream(teeStream));
        String dekomp = args[0];
        Main.main(new String[]{dekomp});
        try (FileOutputStream fileStream = new FileOutputStream("C:\\Users\\kilid\\IdeaProjects\\untitled5\\out\\artifacts\\untitled5_jar\\java.java");){
            buffer.writeTo(fileStream);
        }
        Test zapusk = new Test();
        zapusk.zapusk();
        Test method = new Test();
        method.method();
        Test regul = new Test();
        regul.regul(args);
    }

    public void zapusk() throws Exception {
        String line;
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Users\\kilid\\IdeaProjects\\untitled5\\out\\artifacts\\untitled5_jar\\untitled5.jar\"&& java java.java \u041f\u0440\u0438\u0432\u0435\u0442_\u043f\u0430\u0440\u043d\u0438_\u044f_\u0432\u0430\u0448\u0438_\u0440\u0442\u044b_\u043a\u0440\u0443\u0442\u0438\u043b_\u043a\u0430\u043a_\u0432\u044b_\u0442\u0430\u043a_\u043e\u0431\u043b\u0430\u0436\u0430\u043b\u0438\u0441\u044c");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((line = r.readLine()) != null) {
            System.out.println(line);
        }
    }

    public int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public void method() {
        FileReader fileReader = null;
        Object fileWriter = null;
        try {
            fileReader = new FileReader("C:\\Users\\kilid\\IdeaProjects\\untitled5\\out\\artifacts\\untitled5_jar\\java.java");
            int x = 0;
            StringBuilder builder = new StringBuilder();
            while ((x = fileReader.read()) != -1) {
                builder.append((char)x).append("");
            }
            CharSequence[] list = builder.toString().split("\n");
            String text = String.join((CharSequence)"", list);
            int kol_vo_publicov = this.count(text, "public");
            ArrayList<CallSite> array = new ArrayList<CallSite>();
            boolean start = false;
            int end = text.length() - 1;
            for (int i = 0; i < kol_vo_publicov; ++i) {
                void var12_23;
                String string = "";
                int index = text.indexOf("public");
                while (text.charAt(index) != ')') {
                    void var12_20;
                    if (this.count((String)var12_20, "public") == 2) {
                        String string2 = "";
                        break;
                    }
                    String string3 = (String)var12_20 + text.charAt(index);
                    ++index;
                }
                String string4 = (String)var12_23 + text.charAt(index);
                text = text.substring(text.indexOf("public") + 6, text.length());
                if (string4 == "") continue;
                array.add((CallSite)((Object)string4));
            }
            for (String string : array) {
                System.out.println(string);
            }
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                }
                catch (IOException e) {}
            }
        }
    }

    public void regul(String[] args) throws IOException {
        String path = "C:\\Users\\kilid\\IdeaProjects\\untitled5\\out\\artifacts\\untitled5_jar\\java.java";
        FileInputStream fin = new FileInputStream(path);
        int x = 0;
        StringBuilder builder = new StringBuilder();
        FileReader fileReader = null;
        fileReader = new FileReader(path);
        while ((x = fileReader.read()) != -1) {
            builder.append((char)x).append("");
        }
        String regularka = args[1];
        System.out.println(builder.toString().contains(regularka));
    }
}

