import org.benf.cfr.reader.*;
import java.io.*;
import java.lang.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.output.TeeOutputStream;


public class Test {
    static String os = null;
    static String encoding = System.getProperty("console.encoding", "utf-8");
    static Scanner in = new Scanner(System.in, encoding);
    static Scanner input = new Scanner(System.in, encoding);
    private File destFile;
    // размер буфера для распаковки
    public final int BUFFER = 2048;

    public void unpack(String destinationDirectory, String nameJar) {
        File sourceJarFile = new File(nameJar);
        try {
            File unzipDestinationDirectory = new File(destinationDirectory);
            // открытие zip-архива для чтения
            JarFile jFile = new JarFile(sourceJarFile);
            Enumeration jarFileEntries = jFile.entries();
            while (jarFileEntries.hasMoreElements()) {
                // извлечение текущей записи из архива
                JarEntry entry = (JarEntry) jarFileEntries.nextElement();
                String entryname = entry.getName();
                //entryname = entryname.substring(2);
                System.out.println("Extracting: " + entry);
                destFile = new File(unzipDestinationDirectory, entryname);
                // определение каталога
                File destinationParent = destFile.getParentFile();
                // создание структуры каталогов
                destinationParent.mkdirs();
                // распаковывание записи, если она не каталог
                if (!entry.isDirectory()) {
                    writeFile(jFile, entry);
                }
            }
            jFile.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void writeFile(JarFile jFile, JarEntry entry) throws IOException {
        BufferedInputStream is = new BufferedInputStream(jFile.getInputStream(entry));
        int currentByte;
        byte data[] = new byte[BUFFER];
        // запись файла на диск
        BufferedOutputStream dest = new BufferedOutputStream(new FileOutputStream(destFile), BUFFER);
        while ((currentByte = is.read(data, 0, BUFFER)) > 0) {
            dest.write(data, 0, currentByte);
        }
        dest.flush();
        dest.close();
        is.close();
    }

    public static void main(String[] args) throws Exception {
        Test OS = new Test();
        OS.OS();
        String os_slesh = System.getProperty("file.separator");
        System.out.println("Извлечение данных из jar-архива");
        // расположение и имя архива
        System.out.print("Введите путь к jar-архиву : ");
        String nameJar = in.nextLine();
        String destination = System.getProperty("user.dir") + os_slesh + "Decompiler";
        // куда файлы будут распакованы
        new Test().unpack(destination, nameJar);
        //Установка путей декомпиляции
        System.out.print("Укажите путь для сохранение декомпилированного файла с его именем : ");
        String put_proverki = in.nextLine() + ".java";
        //Определение имени файла с его расширением
        StringBuilder builder = new StringBuilder(put_proverki);
        String var1 = builder.reverse().toString();
        String var2 = StringUtils.substringBefore(var1,os_slesh);
        builder= new StringBuilder(var2);
        String Name_File = builder.reverse().toString();
        //Определение пути до каталога с java файлом
        String var4 = StringUtils.substringBefore(put_proverki,Name_File);
        String put_proverki2 = StringUtils.substring(var4,0,var4.length()-1);
        //Определение диска
        String index = Character.toString(put_proverki.charAt(0));
        String disk = "/"+index;
        //Установка параметра запуска для выводе кода метода
        String destination2 = destination + os_slesh + "Main.class --methodname  ";
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("Декомпилированный код");
        //Вывод данных из консоли
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        OutputStream teeStream = new TeeOutputStream(System.out, buffer);
        // После этой строки любой вывод будет сохраняться в buffer
        System.setOut(new PrintStream(teeStream));
        // Выводим в консоль строку
        Main.main(new String[]{destination + os_slesh + "Main.class"});
        // Сохраняем buffer в файл;
        try (OutputStream fileStream = new FileOutputStream(put_proverki)) {
            buffer.writeTo(fileStream);
        }
        // В java.java теперь данные из консоли
        String logika = buffer.toString(encoding); // Декомплированный файл для проверки методов
        // Передача данных из main
        Test zapusk = new Test();
        zapusk.zapusk(put_proverki2, Name_File,os,disk);
        Test method = new Test();
        method.method(put_proverki);
        Test regul = new Test();
        regul.regul(put_proverki);
        Test Prov_Method = new Test();
        Prov_Method.Prov_Method(destination, destination2,disk);

        // Ввожу имя метода и помещаю его в переменную name_of_method
        System.in.skip(System.in.available()); // Хз зачем, но убрать боюсь. Служит для очистки System.in
        System.out.print("Введите название метода: ");
        String method_to_proverka = input.nextLine();// Имя метода
        System.out.print("Введите параметры метода: ");
        String params = input.nextLine(); // Параметры метода
        // Ввожу тип метода (можно автоматизировать)
        System.out.print("Введите тип метода: ");
        String type = input.nextLine(); // Тип метода
        System.in.skip(System.in.available()); // Хз зачем, но убрать боюсь. Служит для очистки System.in
        input.close();

        // Вызываю метод для проверки отдельных методов

        Test proverka_metodov = new Test();
        proverka_metodov.proverka_metodov(type, params, method_to_proverka,put_proverki,put_proverki2, logika,disk,Name_File);
    }

    public int proverka_metodov(String type, String params, String method,String put_proverki, String put_proverki2, String buffer,String disk,String Name_File) throws IOException {

        String logika = buffer.toString(); // Разархивированный файл

        // Убираю static в методе и создаю свою static функцию
        logika = logika.replace("static void main", "void fun"); // Убираю static

        if (method.contains("main")) { // Смотрю, какой тип. Если void, то просто вызываю метод через объект класса. Если не void, то добавляю System.out.println(). Т.к. тип void нельзя печатать
            method = "fun";
        }
        StringBuilder builder = new StringBuilder(logika); // Помещаю код дек файла в билдер
        int index = builder.indexOf("{"); // Индекс первой фигурной кавычки (нужен, чтобы вставить после нее свой static-метод)
        if (!Objects.equals(type, "void")) {
            builder.insert(index + 1,
                    "public static void main(String[] args){" +
                            "Main perem = new Main(); " +
                            "System.out.println(perem." + method + "(" + params + "));}"); // Вставляю на место index + 1 (т.е. после фигурной скобки) новый статик-метод. Объявляю в нем объект класса и вызываю указанный через терминал метод.
        } else { // То же самое, только для типа метода void
            builder.insert(index + 1,
                    "public static void main(String[] args){" +
                            "Main perem = new Main(); " +
                            "perem." + method + "(" + params + ");}");
        }
        logika = builder.toString(); // Сохраняем результат


        Path path = Paths.get(put_proverki); // Создаю переменную с путем к файлу, где указано его название и расширение
        Files.write(path, Collections.singleton(logika)); // Записываю в файл

        // Запускаю код через cmd и вывожу результат запуска
        String line;
        if(os.equals("Windows")) {
            ProcessBuilder Win = new ProcessBuilder("cmd.exe", disk, "cd " + put_proverki2 + "&& java " + Name_File); //для Windows
            Win.redirectErrorStream(true);
            Process win = Win.start();
            BufferedReader w = new BufferedReader(new InputStreamReader(win.getInputStream()));
            while (true) {
                line = w.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            w.close();
        }
        if(os.equals("Linux")) {
            ProcessBuilder Lin = new ProcessBuilder("/bin/bash", "-c", " cd " + put_proverki2 + " && java " + Name_File); // для Linux
            Lin.redirectErrorStream(true);
            Process lin = Lin.start();
            BufferedReader l = new BufferedReader(new InputStreamReader(lin.getInputStream()));
            while (true) {
                line = l.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            l.close();
        }
        if(os.equals("Mac")) {
            ProcessBuilder Mac = new ProcessBuilder("/bin/bash", "-c", " cd " + put_proverki2 + " && java " + Name_File); //для Windows
            Mac.redirectErrorStream(true);
            Process mac = Mac.start();
            BufferedReader m = new BufferedReader(new InputStreamReader(mac.getInputStream()));
            while (true) {
                line = m.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            m.close();
        }
        return 0;
    }

    public String OS( ) {

        if (SystemUtils.IS_OS_WINDOWS)
            os = "Windows";
        if (SystemUtils.IS_OS_LINUX)
            os = "Linux";
        if (SystemUtils.IS_OS_MAC)
            os = "Mac";
        return os;
    }

    public void zapusk (String put_proverki2, String Name_File,String os, String disk) throws Exception {
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("Результат запущенного кода");

        String line;
        if(os.equals("Windows")) {
            ProcessBuilder Win = new ProcessBuilder("cmd.exe", disk, "cd " + put_proverki2 + "&& java " + Name_File); //для Windows
            Win.redirectErrorStream(true);
            Process win = Win.start();
            BufferedReader w = new BufferedReader(new InputStreamReader(win.getInputStream()));
            while (true) {
                line = w.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            w.close();
        }
        if(os.equals("Linux")) {
            ProcessBuilder Lin = new ProcessBuilder("/bin/bash", "-c", " cd " + put_proverki2+ " && java " + Name_File); // для Linux
            Lin.redirectErrorStream(true);
            Process lin = Lin.start();
            BufferedReader l = new BufferedReader(new InputStreamReader(lin.getInputStream()));
            while (true) {
                line = l.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            l.close();
        }
        if(os.equals("Mac")) {
            ProcessBuilder Mac = new ProcessBuilder("/bin/bash", "-c", " cd " + put_proverki2 + " && java " + Name_File); //для Windows
            Mac.redirectErrorStream(true);
            Process mac = Mac.start();
            BufferedReader m = new BufferedReader(new InputStreamReader(mac.getInputStream()));
            while (true) {
                line = m.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            m.close();
        }

    }

    public int count (String str, String target){
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    public void method (String put_proverki){
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("Методы проверяемого кода");
        FileReader fileReader = null;
        try {
            // У FileReader есть конструктор, принимающий адрес
            // файла, который необходимо читать
            fileReader = new FileReader(put_proverki);
            int x = 0;
            StringBuilder builder = new StringBuilder();
            while ((x = fileReader.read()) != -1) {
                builder.append((char) x).append("");
            }
            String[] list = builder.toString().split("\n");
            String text = String.join("", list);
            // *Тут работаем с файлом*
            int kol_vo_publicov = count(text, "public");
            List<String> array = new ArrayList<>();
            for (int i = 0; i < kol_vo_publicov; i++) {
                String str = "";
                int index = text.indexOf("public");
                while (text.charAt(index) != ')') {
                    if (count(str, "public") == 2) {
                        str = "";
                        break;
                    }
                    str += text.charAt(index);
                    ++index;
                }
                str += text.charAt(index);
                text = text.substring(text.indexOf("public") + 6, text.length());
                if (str != "") {
                    array.add(str);
                }
            }
            for (String i : array) {
                System.out.println(i);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            // Указанный файл не найден или произошла ошибка доступа
            // (например, нет прав на чтение)
            e.printStackTrace();
        } catch (IOException e) {
            // Произошла общая ошибка ввода-вывода
            // (например, попытались прочесть больше, чем возможно)
            e.printStackTrace();
        } finally {
            // FileReader должен быть закрыт в любом случае
            if (fileReader != null) {
                try {
                    // Закрытие тоже может сгенерировать исключение
                    fileReader.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public void regul (String put_proverki) throws IOException {
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("Проверка регулярного выражения");
        // Считываем данные файла
        int x = 0;
        StringBuilder builder = new StringBuilder();
        FileReader fileReader = null;
        fileReader = new FileReader(put_proverki);
        while ((x = fileReader.read()) != -1) {
            builder.append((char) x).append("");
        }
        // Смотрим по регулярке данные
        System.out.print("Введите регулярное выражение: ");
        String reg = in.nextLine();
        Matcher m = Pattern.compile(reg).matcher(builder.toString());
        System.out.println(m.find());

        // Вывод номера строки
        File file = new File(put_proverki);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        int lineNr = 1;
        while (line != null) {
            Matcher m2 = Pattern.compile(reg).matcher(line);
            if(m2.find()){
                System.out.println("line " + lineNr);
            }
            line = reader.readLine();
            lineNr++;
        }
    }

    public void Prov_Method (String destination, String destination2,String disk) throws Exception {
        System.out.println("_____________________________________________________________________________________________");
        System.out.println("Проверка метода");
        System.out.print("Введите метод: ");
        String Method = in.nextLine();

        String line;
        if(os.equals("Windows")) {
            ProcessBuilder Win = new ProcessBuilder("cmd.exe", disk, "cd " + destination + "&& java -jar cfr-0.152.jar " + destination2 + Method); //для Windows
            Win.redirectErrorStream(true);
            Process win = Win.start();
            BufferedReader w = new BufferedReader(new InputStreamReader(win.getInputStream()));
            while (true) {
                line = w.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            w.close();
        }
        if(os.equals("Linux")) {
            ProcessBuilder Lin = new ProcessBuilder("/bin/bash", "-c", " cd " + destination + "&& java -jar cfr-0.152.jar " + destination2 + Method); // для Linux
            Lin.redirectErrorStream(true);
            Process lin = Lin.start();
            BufferedReader l = new BufferedReader(new InputStreamReader(lin.getInputStream()));
            while (true) {
                line = l.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            l.close();
        }
        if(os.equals("Mac")) {
            ProcessBuilder Mac = new ProcessBuilder("/bin/bash", "-c", " cd " + destination + "&& java -jar cfr-0.152.jar " + destination2 + Method); //для Windows
            Mac.redirectErrorStream(true);
            Process mac = Mac.start();
            BufferedReader m = new BufferedReader(new InputStreamReader(mac.getInputStream()));
            while (true) {
                line = m.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            m.close();
        }
    }
}