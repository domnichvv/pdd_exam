package com.uischool.pdd;

import java.awt.*;

/**
 * Created by Влад on 03.11.2016.
 */
public class MyConstants {

    //размеры текстовых полей для окна авторизации
    public static final int AUTH_FIELD_WIDTH = 10;

    //размеры и расстояния от компонентов окна авторизации
    public static final int BORDER_EMPTY = 25;
    public static final int DISTANCE_BETWEEN_COMPONENTS = 10;
    public static final int DISTANCE_BETWEEN_LAYOUT_VERTICAL = 6;
    public static final int DISTANCE_BETWEEN_ANSWERS = 15;
    public static final int DISTANCE_BETWEEN_ANSWERS_LABEL = 90;
    public static final int DISTANCE_BETWEEN_LAYOUT_AND_BUTTONS_VERTICAL = 15;

    //текст для компонентов окна авторизации
    public static final String VIEW_TITLE_AUTH = "Авторизация";
    public static final String VIEW_LABEL_LOGIN = "Логин";
    public static final String VIEW_LABEL_PASS = "Пароль";
    public static final String VIEW_BUTTON_TEXT_ENTRANCE = "Войти";
    public static final String VIEW_BUTTON_TEXT_CANCEL = "Выйти";
    public static final String VIEW_BUTTON_TEXT_REG = "Регистрация";

    //размеры для текстовых полей окна регистрации
    public static final int REG_FIELD_WIDTH = 10;

    //текст для компонентов окна регистрации
    public static final String VIEW_TITLE_REG = "Регистрация";
    public static final String VIEW_LABEL_LOGIN_REG = "Логин";
    public static final String VIEW_LABEL_PASS_REG = "Пароль";
    public static final String VIEW_LABEL_REPEAT_PASS_REG = "Повторите пароль";
    public static final String VIEW_BUTTON_TEXT_ZAREG = "Зарегистрироваться";
    public static final String VIEW_BUTTON_TEXT_BACK = "Назад";

    //размеры для главного окна приложения
    public static final int MAIN_SCREEN_WIDTH = 600;
    public static final int MAIN_SCREEN_HEIGHT = 400;

    //текст для компонентов главного окна приложения
    public static final String VIEW_TITLE_MAIN = "Тестирование ПДД";
    public static final String VIEW_BUTTON_TRAINING = "Пройти обучение";
    public static final String VIEW_BUTTON_TESTING = "Сдать экзамен";
    public static final String VIEW_BUTTON_EXIT = "Выйти";

    //размеры для компонентов и окна бучения
    public static final int TRAINING_SCREEN_WIDTH = 700;
    public static final int TRAINING_SCREEN_HEIGHT = 440;
    public static final int DISTANCE_BETWEEN_BUTTONS = 30;

    //текст для компонентов окна обучения
    public static final String VIEW_TITLE_TRAINING = "Обучение";
    public static final String VIEW_TRAINING_HEADER = "Обучающий материал ПДД";
    public static final String VIEW_BUTTON_NEXT = "Следующая";
    public static final String VIEW_BUTTON_PREV = "Предыдущая";
    public static final String VIEW_BUTTON_TO_MAIN = "Завершить";

    //размеры для компонентов и окна тестирования
    public static final int TESTING_SCREEN_WIDTH = 630;
    public static final int TESTING_SCREEN_HEIGHT = 430;

    //текст для компонентов окна тестирования
    public static final String VIEW_TITLE_TESTING = "Экзамен";
    public static final String VIEW_TESTING_HEADER = "Тестирование правил дорожного движения";
    public static final String VIEW_BUTTON_ANSWER= "Ответить";
    public static final String VIEW_BUTTON_NEXT_QUESTION = "Следующий вопрос";
    public static final String VIEW_BUTTON_END = "Завершить";
    public static final String VIEW_MESSAGE_MUST_BE_ONE_ANSWER = "Только один правильный ответ!";

    //текст для компонентов админ панели
    public static final String VIEW_TITLE_ADMIN = "Администратор";

    //размеры для компонентов и окна админ панели
    public static final int ADMIN_SCREEN_WIDTH = 600;
    public static final int ADMIN_SCREEN_HEIGHT = 800;

    //текст для сообщений
    public static final String VIEW_MESSAGE_DIALOG_SUCCESSFUL_AUTH = "Авторизация прошла успешно. Добро пожаловать!";
    public static final String VIEW_MESSAGE_DIALOG_USER_NOT_FOUND = "Пользователь с таким логином и паролем не найден. " +
            "Зарегистрируйтесь пожалуйста!";
    public static final String VIEW_MESSAGE_DIALOG_EMPTY_FIELD = "Поля для ввода не могут быть пустыми!";
    public static final String VIEW_MESSAGE_DIALOG_SUCCESSFUL_ZAREG = "Вы успешно зарегистрировались!";
    public static final String VIEW_MESSAGE_DIALOG_NOT_EQUALS_PASS = "Вы ввели не одинаковые пароли!";
    public static final String VIEW_MESSAGE_DIALOG_SIMVOL_PASS = "Для лучшей безопасности пароль должен иметь 8 и более символов.";
    public static final String VIEW_MESSAGE_DIALOG_ADMIN = "Вы вошли на правах администратора. Добро пожаловать!";
    public static final String VIEW_MESSAGE_WRONG_ANSWER = "Неверно";
    public static final String VIEW_MESSAGE_RIGHT_ANSWER = "Верно";
    public static final String VIEW_MESSAGE_ABOUT_FINISH_TRAINING = "Вы прошли обучение! Можете сдавать экзамен";
    public static final String VIEW_MESSAGE_EXIT_FROM_TRAINING = "Прогресс прохождения обучения будет утеряно. Вы действительно хотите завершить?";
    public static final String VIEW_MESSAGE_EXIT_FROM_TRAINING_TITLE = "Завершение обучения";
    public static final String VIEW_MESSAGE_DIALOG_EMPTY_ANSWER = "Сделайте выбор!";
    public static final String VIEW_MESSAGE_EXIT_FROM_TESTING = "Прогресс тестирования будет утеряно. Вы действительно хотите завершить?";
    public static final String VIEW_MESSAGE_EXIT_FROM_TESTING_TITLE = "Завершение тестирования";
    public static final String VIEW_MESSAGE_ABOUT_FINISH_TESTING = "Вы прошли тестирование!";
    public static final String VIEW_MESSAGE_ABOUT_NOT_FINISH_TESTING = "Вы не прошли тестирование. У Вас не хватило правильных ответов." +
            " Для положительного результата, нужно правильно ответить минимум на 15 ответов.";
    public static final String VIEW_MESSAGE_RIGHT_ANSWERS = "Правильных ответов - ";
    public static final String VIEW_MESSAGE_WRONG_ANSWERS = "Ошибочных ответов - ";
    public static final String VIEW_MESSAGE_DIALOG_NOT_FINISH_TRAINING = "Вы не прошли обучение! Это может стать причиной неправильных ответов. Продолжить?";
    public static final String VIEW_MESSAGE_DIALOG_TITLE_NOT_FINISH_TRAINING = "Внимание! Вы не прошли обучение.";
    public static final String VIEW_MESSAGE_DIALOG_NOT_ANSWER = "Вы не ответили на вопрос!";


    public static final String PATH_TO_IMAGE_FINISH_TRAINING = "images/the_end.jpg";
    public static final String PATH_TO_TITLE_IMAGE = "images/znak.png";
    public static final String PATH_TO_IMAGE_IN_MAIN = "images/svetofor.jpg";
    public static final String FILE_NAME = "users.json";
    public static final String USERS_START_STATUS = "not completed";
    public static final String USERS_FINAL_STATUS = "completed";

    //данные пользователя
    public static final String ADMIN_LOGIN = "vlad";
    public static final String ADMIN_PASS = "77777777";
}
