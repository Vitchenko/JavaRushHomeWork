package com.javarush.test.level18.lesson10.bonus01;


/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/




import java.io.*;

public class Solution
{

    public static void main(String[] args) throws IOException {

        if (args[0].equals("-e")){

            FileInputStream fis = new FileInputStream(args[1]);
            FileOutputStream fos = new FileOutputStream(args[2]);

            byte[] fileNotEnrypt = new byte[fis.available()];
            fis.read(fileNotEnrypt);
            String keyWord = "Key1";
            fos.write(encrypt(fileNotEnrypt, keyWord));

            fis.close();
            fos.close();
        }

        if (args[0].equals("-d")){

            FileInputStream fis = new FileInputStream(args[1]);
            FileOutputStream fos = new FileOutputStream(args[2]);

            byte[] fileEnrypt = new byte[fis.available()];
            fis.read(fileEnrypt);
            String keyWord = "Key1";
            fos.write(decrypt(fileEnrypt, keyWord));

            fis.close();
            fos.close();
        }
    }
    public static byte[] encrypt(byte[] arr, String keyWord)
    {
        byte[] keyarr = keyWord.getBytes();
        byte[] result = new byte[arr.length];
        for(int i = 0; i< arr.length; i++)
        {
            result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]);
        }
        return result;
    }
    public static byte[] decrypt(byte[] text, String keyWord)
    {
        byte[] result  = new byte[text.length];
        byte[] keyarr = keyWord.getBytes();
        for(int i = 0; i < text.length;i++)
        {
            result[i] = (byte) (text[i] ^ keyarr[i% keyarr.length]);
        }
        return result;
    }

//    public static void main(String[] args) throws IOException, NoSuchAlgorithmException
//    {
//        String key = args[0];
//        String fname = args[1];
//        String outname = args[2];
//        String str = null;
//        SecretKey myDesKey=GetKey();
//
//        //GenKey();
//
//        FileInputStream in = new FileInputStream(fname);
//        FileOutputStream out = new FileOutputStream(outname);
//
//        if (key.equals("-e")){
//        try {
//            byte[] buf = new byte[in.available()];
//            while (in.available() > 0)
//            {
//                int count = in.read(buf);
//                out.write(CriptD(buf,myDesKey));
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            in.close();
//            out.close();
//        }}else
//        {
//            try {
//                byte[] buf = new byte[in.available()];
//                while (in.available() > 0)
//                {
//                    int count = in.read(buf);
//                    out.write(DeCriptD(buf,myDesKey));
//                }
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//            finally
//            {
//                in.close();
//                out.close();
//            }
//        }
//
//    }
//
//    public static void GenKey() throws NoSuchAlgorithmException, IOException
//    {
//        KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
//        SecretKey myDesKey = keygenerator.generateKey();
//
//        FileOutputStream out = new FileOutputStream("d:/key.txt");
//
//            try {
//                out.write(myDesKey.getEncoded());
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//            finally
//            {
//                out.close();
//            }
//    }
//
//    public static SecretKey GetKey() throws NoSuchAlgorithmException, IOException
//    {
//        //SecretKey myDesKey;
//        FileInputStream in = new FileInputStream("d:/key.txt");
//        byte[] decodedKey=new byte[in.available()];
//        SecretKey originalKey=null;
//
//        try {
//            while(in.available()>0)
//            {
//                int count = in.read(decodedKey);
//            }
//            originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            in.close();
//        }
//
//        return originalKey;
//    }
//
//
//    public static byte[] CriptD(byte[] inarr, SecretKey myDesKey)
//    {
//
//        byte[] textEncrypted = new byte[0];
//        try
//        {
//            Cipher desCipher;
//
//            // Create the cipher
//            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//
//            // Initialize the cipher for encryption
//            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
//
//            textEncrypted = desCipher.doFinal(inarr);
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return textEncrypted;
//    }
//
//
//
//
//    public static byte[] DeCriptD(byte[] inarr, SecretKey myDesKey)
//    {
//
//        byte[] textEncrypted = new byte[0];
//        try
//        {
//            Cipher desCipher;
//
//            // Create the cipher
//            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
//
//            // Initialize the same cipher for decryption
//            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
//
//            // Decrypt the text
//            byte[] textDecrypted = desCipher.doFinal(inarr);
//
//            return textDecrypted;
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return textEncrypted;
//
//    }

}