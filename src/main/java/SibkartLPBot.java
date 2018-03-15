import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class SibkartLPBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || update.getMessage().hasText()) {
        }

        String messageText = update.getMessage().getText();

        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                .setChatId(update.getMessage().getChatId())
                .setText(update.getMessage().getText());
        if ("/start".equals(messageText)) {
            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboard = new ArrayList();
            KeyboardRow row = new KeyboardRow();
            KeyboardButton keyboardButton = new KeyboardButton("register");
            keyboardButton.setRequestContact(true);

            row.add(keyboardButton);
            keyboard.add(row);
            keyboardMarkup.setKeyboard(keyboard);
            message.setReplyMarkup(keyboardMarkup);
        }

        try {
            execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return "sibkartbot";
    }

    public String getBotToken() {
        return "520741905:AAHwzR2Y2mHj0gpNB9aMZzk3L1sX8nGlqAU";
    }
}
