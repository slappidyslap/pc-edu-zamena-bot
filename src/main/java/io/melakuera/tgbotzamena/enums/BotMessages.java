package io.melakuera.tgbotzamena.enums;

import static com.vdurmont.emoji.EmojiParser.parseToUnicode;

public enum BotMessages {

	START(parseToUnicode("Добавьте меня в вашу группу и сделайте меня админом!")),
	
	START_IN_GROUP(parseToUnicode(
			"""
			И так начинаем! Сперва убедитесь, что я являюсь админом. 
			Если все в порядке, то укажите группу для получения входящих
			замен [следующим образом:](%s)
			""")),
	
	//Вы в любой момент можете отписаться от рассылок

	//[inline mention of a user](tg://user?id=881428788)

	SUCCESS_APPLY_FACULTY(parseToUnicode("Выбрана группа:")),
	
	CONGRATULATION(parseToUnicode("Поздравляем вы успешно подписались на замены "
			+ "группы %s! Если вы желаете, чтобы я именно ВАС упомянул при новых замен, "
			+ "просто введите команду /in")),
	
	CONGRATULATION_IF_EXISTS(parseToUnicode("Вы успешно поменяли подписку на группу %s! "
			+ "Если вы желаете, чтобы я именно ВАС упомянул при новых замен, "
			+ "просто введите команду /in")),
	
	INFO("""
			Вы на данный момент подписаны на %s

			Сведение по командам:
			/start - Начать
			/in - Подписаться на входящие замены
			/out - Отписаться от входящих замен
			/info - Мне нужно писать для чего это команда?
			/quit - Перестать получать входящие замены
			
			В: Почему подписка поменялясь на другую группу? 
			
			О: Кто-то из вас поменял подписку. Исправить ситуцию можно как [видео ниже](%s)
			
			В: А что с моими личными данными? Этот бот прослеживает что происходит в нашей группе? И зачем тебе админка?!
			
			О: Насчет этого вы можете абсолютно не беспокоится. Потому что сам Телеграм позаботился о ваших конфиденциальных данных. Так, я и этот бот не в состоянии сделать, что то масштабное с вашими пользовательским идентификатором, которую причем вы можете добыть довольно тривиальным образом.
			Подробнее: https://telegram.org/faq#q-what-are-your-thoughts-on-internet-privacy
			Роль администратора необходима, потому что я закрепляю сообщения
			Подробнее: https://core.telegram.org/bots/api#pinchatmessage
			
			В: Я нашел ошибку! Я хочу дополнить функционал бота!
			
			О: Тогда смело в гитхаб:  https://github.com/slappidyslap/pc-edu-zamena-bot
					
		"""),
	
	APPLY_MENTION("Принято!"),
	
	MENTION_ERROR("Так нельзя!"),
	
	QUIT(parseToUnicode("Вы уверены в этом?")),
	
	QUIT_NO(parseToUnicode("Таки быть")),
	
	QUIT_YES(parseToUnicode("До свидос!")),
	
	QUIT_YES_ERROR(parseToUnicode("Вы еще не подписались на ни одну группу!"));

	private final String message;

	private BotMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
