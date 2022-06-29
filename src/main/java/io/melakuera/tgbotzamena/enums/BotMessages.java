package io.melakuera.tgbotzamena.enums;

import static com.vdurmont.emoji.EmojiParser.parseToUnicode;

/*
 * Шаблоны сообщений бота
 */
public enum BotMessages {

	// Стартовое сообщение если бот запущен не в группе 
	START(parseToUnicode("Добавьте меня в вашу группу и сделайте меня админом!")),
	
	// Стартовое сообщение если бот запущен в группе 
	START_IN_GROUP(parseToUnicode(
			"""
			И так начинаем! Сперва посмотрите справку по боту с помощью команды /info. Дальше  не забудьте мне назначить *роль админа*, иначе я не смогу закреплять сообщения. И далее укажите группу для получения входящих замен [следующим образом:](%s).
			Вы в любой момент можете перестать получать замены с помощью команды /quit.
			""")),

	// Сообщение, который займет текст после inline query
	SUCCESS_APPLY_FACULTY(parseToUnicode("Выбрана группа:")),
	
	// Сообщение, если подписка на группу из колледжа произошла успешно
	CONGRATULATION(parseToUnicode("Поздравляем вы успешно подписались на замены "
			+ "группы %s! Если вы желаете, чтобы я именно *вас* упомянул при новых замен, "
			+ "просто введите команду /in")),
	
	// Сообщение, если у телеграм-группы ранее уже была подписка на группу из колледжа
	CONGRATULATION_IF_EXISTS(parseToUnicode("Вы успешно поменяли подписку на группу %s! "
			+ "Если вы желаете, чтобы я именно *вас* упомянул при новых замен, "
			+ "просто введите команду /in")),
	
	// Сообщение, который выводится командой /info
	INFO("""
			Вы на данный момент подписаны %s

			Сведение команд и запросов:
			/start - Получить начальное сообщение
			%s <наименование факультета> - Начать получать замены данной группы (высветиться подсказка)
			/in - Подписаться на входящие замены (Бот упомянет *вас*, когда пришла новая замена)
			/out - Отписаться от входящих замен (Бот перестанет упоминать *вас*)
			/info - Мне нужно писать для чего это команда?
			/quit - Перестать получать входящие замены (Иначе говоря, он будет бездействовать)
			
			В: Почему бот стал отправлять замены иной группы?
			
			О: Кто-то из вас сменил группу, замены которох вы получаете. Исправить ситуцию можно как [видео ниже](%s). Так же можно узнать замены какой группы вы прослеживаете с помощью команды /info, группа указана сверху.
			
			В: А что с моими личными данными? Этот бот прослеживает что происходит в нашей группе? И зачем тебе админка?!
			
			О: Насчет этого вы можете абсолютно не беспокоится. Потому что сам Телеграм позаботился о ваших конфиденциальных данных. Так, я и этот бот не в состоянии сделать, что то масштабное с вашими пользовательским идентификатором, которую причем вы можете добыть довольно тривиальным образом. Подробнее: https://telegram.org/faq#q-what-are-your-thoughts-on-internet-privacy Роль администратора необходима, потому что я закрепляю сообщения Подробнее: https://core.telegram.org/bots/api#pinchatmessage
			
			В: Я нашел ошибку! 
			
			О: Обратиться: @paradisenseii
				
			В: У меня есть идея! Я хочу дополнить функционал бота!	
			
			О: Тогда смело в гитхаб:  https://github.com/slappidyslap/pc-edu-zamena-bot
		"""),
	
	// Сообщение, который выводится при успешном результате команды /in и /out
	APPLY_MENTION("Принято!"),
	
	// Сообщение, который выводится при ошибке результата команды /in и /out
	MENTION_ERROR("Так нельзя!"),
	
	// Сообщение, который выводится командой /quit
	QUIT(parseToUnicode("Вы уверены, что хотите перестать получать замены?")),
	
	// Текст сообщение, который применяется при callback query /quit_no
	QUIT_NO(parseToUnicode("Таки быть")),
	
	// Текст сообщение, который применяется при callback query /quit_yes
	QUIT_YES(parseToUnicode("До свидос!")),
	
	// Текст сообщение, который применяется при ошибочном 
	// результате callback query /quit_yes
	QUIT_YES_ERROR(parseToUnicode("Вы еще не подписались на ни одну группу!"));

	private final String message;

	private BotMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
