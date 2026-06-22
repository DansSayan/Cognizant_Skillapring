public class Main {
    public static void main(String[] args) {
        String message = "Message successfully sent!";
        System.out.println("Email");
        Notifier basicEmail = new EmailNotifier();
        basicEmail.send(message);

        System.out.println("\nEmail + SMS");
        Notifier emailAndSms = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSms.send(message);

        System.out.println("\nEmail + SMS + Slack");
        Notifier ultraStack = new SlackNotifierDecorator(
                                  new SMSNotifierDecorator(
                                      new EmailNotifier()
                                  )
                              );
        ultraStack.send(message);
    }
}