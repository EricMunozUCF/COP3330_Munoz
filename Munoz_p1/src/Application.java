public class Application {
    public static void main(String[] args)
    {
        String encrypted = Encrypter.encrypt("5876");
        String decrypted = Decrypter.decrypt(encrypted);

        System.out.printf("\n%s\n%s", encrypted, decrypted);

    }

}
