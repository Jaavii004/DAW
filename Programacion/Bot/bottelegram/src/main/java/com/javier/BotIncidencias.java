package com.javier;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;
import java.util.Map;

public class BotIncidencias extends TelegramLongPollingBot {

    private enum BotState {
        NORMAL, ESPERANDO_NUMERO_INCIDENCIA, ESPERANDO_ID_INCIDENCIA_ESTADO
    }
    
    private BotState botState = BotState.NORMAL;
    private String chatIdEsperandoIncidencia;

    // Mapa para almacenar los IDs de chat de los usuarios
    private Map<Long, String> userChatIds = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            String userName = message.getFrom().getFirstName();
            Long userId = message.getFrom().getId(); // Obtener el ID de usuario
            userChatIds.put(userId, chatId); // Almacenar el ID de chat del usuario

            if (botState == BotState.ESPERANDO_NUMERO_INCIDENCIA) {
                try {
                    int numeroIncidencia = Integer.parseInt(message.getText());
                    // Obtener el ID de chat del usuario que está en el estado de espera
                    String chatIdUsuario = userChatIds.get(message.getFrom().getId());
                    System.out.println("Incidencia número " + numeroIncidencia + " cerrada.");
                    sendMsg(chatIdUsuario, "La incidencia número " + numeroIncidencia + " ha sido cerrada.");
                    // Cambiar el estado del bot de vuelta a normal
                    botState = BotState.NORMAL;
                } catch (NumberFormatException e) {
                    // El mensaje no es un número, enviar mensaje de error
                    sendMsg(chatIdEsperandoIncidencia, "El número de incidencia ingresado no es válido. Por favor, intenta nuevamente.");
                }
            }
            if (botState == BotState.ESPERANDO_ID_INCIDENCIA_ESTADO) {
                try {
                    int numeroIncidencia = Integer.parseInt(message.getText());
                    // Obtener el ID de chat del usuario que está en el estado de espera
                    String chatIdUsuario = userChatIds.get(message.getFrom().getId());
                    System.out.println("Incidencia número "+numeroIncidencia+" esta en estado Abierta");
                    sendMsg(chatIdUsuario, "La incidencia número Incidencia número "+numeroIncidencia+" esta en estado Abierta");
                    // Cambiar el estado del bot de vuelta a normal
                    botState = BotState.NORMAL;
                } catch (NumberFormatException e) {
                    // El mensaje no es un número, enviar mensaje de error
                    sendMsg(chatIdEsperandoIncidencia, "El número de incidencia ingresado no es válido. Por favor, intenta nuevamente.");
                }
            }

            if (message.getText().equals("/start") || message.getText().equals("/ayuda")) {
                // Si el mensaje es /start, enviar las funciones disponibles
                // Aqui hay que poner userName
                sendMsg(chatId, "Hola " +  ", soy el bot PrintProManager. ¿Qué quieres saber?\n" + 
                                "/start - Iniciar el bot\n" +
                                "/cerrarIncidencia - Cerrar incidencia\n" +
                                "/listIncidenciasDiarias - Lista con todas las incidencias del día\n" +
                                "/EnviarIncidencia - Enviar incidencia\n" +
                                "/NumIdenciasAbiertas - Ver el estado de las impresoras\n" +
                                "/EstadoIncidencia - En que estado esta la incidencia\n" +
                                "/ayuda - Mostrar ayuda\n");
            }
            if (message.getText().equals("/cerrarIncidencia")) {
                // Cambiar el estado del bot para esperar el número de incidencia
                botState = BotState.ESPERANDO_NUMERO_INCIDENCIA;
                chatIdEsperandoIncidencia = chatId;
                sendMsg(chatId, "Por favor, ingresa el número de la incidencia que deseas cerrar:");
            }
            if (message.getText().equals("/listIncidenciasDiarias")) {
                sendMsg(chatId, "Lista de todas las incidencias del día:");
            }
            if (message.getText().equals("/NumIdenciasAbiertas")) {
                sendMsg(chatId, "Hay 3 incidencias abiertas. 🖨️🖨️🖨️");
            }
            if (message.getText().equals("/EnviarIncidencia")) {
                sendMsg(chatId, "Estos son los detalles de tu icidencia:\n" + 
                                "Descripción: \n" + 
                                "Fecha: \n" + 
                                "Hora: \n" + 
                                "Estado: \n" + 
                                "Incidencia enviada con éxito. 🖨️🖨️🖨️");
            }
            if (message.getText().equals("/EstadoIncidencia")) {
                sendMsg(chatId, "Por favor, ingresa el número de la incidencia que deseas saber su estado:");
                chatIdEsperandoIncidencia = chatId;
                botState = BotState.ESPERANDO_ID_INCIDENCIA_ESTADO;
            }
            String reservationMessage = "No se exactamente que quieres hacer.... 🤔\n" + 
                                        "Pero te reservaré una impresora para ti. 🖨️\n";
            sendMsg(chatId, reservationMessage);
        }
    }
    //@Override
    //public void onUpdateReceived(Update update) {
    //    if (update.hasMessage() && update.getMessage().hasText()) {
    //        System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName() + ": " + update.getMessage().getText());
    //        Message message = update.getMessage();
    //        String chatId = message.getChatId().toString();
    //        String userName = "Tu usuario";
    //        userName = message.getFrom().getFirstName();
    //        String usuario = userName+" ";
    //        if (message.getText().equals("/start")) {
    //            String mensaje = "Hola " + usuario + ", soy el bot PrintProManager. ¿Qué quieres saber?\n" + 
    //                            "/start - Iniciar el bot\n" +
    //                            "/listIncidenciasDiarias - Lista con todas las incidencias del día\n" +
    //                            "/cerrarIncidencia - Cancelar la reserva\n" +
    //                            "/numeroIncidenciasAbiertas - Ver el estado de las impresoras\n" +
    //                            "/ayuda - Mostrar ayuda\n";
    //            sendMsg(chatId, mensaje);
    //        }
    //        if (message.getText().equals("/cerrarIncidencia")) {
    //            String preguntaNombre = "Por favor, ingresa el numero de la incidencia:";
    //            sendMsg(chatId, preguntaNombre);
    //            String incidenciaNumero = message.getText();
    //            System.out.println("Incidencia numero: " + incidenciaNumero);
    //        } else {
    //            // Si no es /start ni /cerrarIncidencia, procesar el mensaje como antes
    //            String reservationMessage = "Reserva de  ✔️";
    //            sendMsg(chatId, reservationMessage);
    //        }
    //    }
    //}


    /**
     * Method for creating a message and sending it.
     *
     * @param chatId chat id
     * @param s      The String that you want to send as a message.
     * @throws TelegramApiException 
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the bot's name, which was specified during registration.
     *
     * @return bot name
     */
    @Override
    public String getBotUsername() {
        return "@PrintProManager_bot";
    }

    /**
     * This method returns the bot's token for communicating with the Telegram
     * server
     *
     * @return the bot's token
     */
    @Override
    public String getBotToken() {
        return "7072960059:AAG7IbEpwpPffUADI1nDfbYJMyFUbgysac8";
    }

    /**
     * Method for starting the bot.
     */
    public void startPolling() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BotIncidencias bot = new BotIncidencias();
        bot.startPolling();
    }
}