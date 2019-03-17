import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class KabanBot extends TelegramLongPollingBot {
    private static final String START = "/start";
    private static final String HELP = "/help";
    private static final String TRANSLATE = "/translate";

    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText()) {
            if (update.getMessage().getText().equals(START)) {
                onStartMessage(update);
            } else if (update.getMessage().getText().equals(HELP)) {
                onHelpMessage(update);
            } else if (update.getMessage().getText().contains(TRANSLATE)) {
                translate(update);
            }
        }
    }

    private void onStartMessage(Update update) {
        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId());
        String startMassage = "Прыветанне, гэта белурсая лаянка. Нацiснi \"Дапамога\", как убачыць што рабiць";
        message.setText(startMassage);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void onHelpMessage(Update update) {
        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId());
        String startMassage = "Вось што я раблю, курва.";
        message.setText(startMassage);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void translate(Update update) {
        //TODO translator
        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId());
        String startMassage = "Перакладаю";
        message.setText(startMassage);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "Kaban_666_bot";
    }

    public String getBotToken() {
        return "634261680:AAFr4uAvT6J93DTOg_bm5WxGO5y6bp7-ngk";
    }
}
