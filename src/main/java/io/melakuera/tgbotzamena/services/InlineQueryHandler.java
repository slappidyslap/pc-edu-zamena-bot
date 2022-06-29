package io.melakuera.tgbotzamena.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;

import io.melakuera.tgbotzamena.enums.BotMessages;
import lombok.RequiredArgsConstructor;

/*
 * Обработчик встроенных запросов 
 * (inline queries: https://core.telegram.org/bots/api#inline-mode)
 */
@Service
@RequiredArgsConstructor
public class InlineQueryHandler {

	public BotApiMethod<?> handleInlineQuery(InlineQuery inlineQuery) {

		String query = inlineQuery.getQuery();
		
		List<InlineQueryResultArticle> articles = 
				getInlineQueryResultsByFaculty(query);

		return AnswerInlineQuery.builder()
				.inlineQueryId(inlineQuery.getId())
				.results(articles)
				.build();
	}

	public List<InlineQueryResultArticle> getInlineQueryResultsByFaculty(
			String facultyRusName) {

		switch (facultyRusName) {
			case "ЭкСС", "СССК": return getInlineQueryResultsByEKSSOrSSSK(facultyRusName);
			case "ЭССС": return getInlineQueryResultsByESSS(facultyRusName);
			case "ПКС", "КС": return getInlineQueryResultsByPKSOrKS(facultyRusName);
			default: return Collections.emptyList();
		}
	}
	
	private List<InlineQueryResultArticle> getInlineQueryResultsByEKSSOrSSSK(
			String facultyRusName) {
		
		int currentYear = LocalDate.now().getYear() % 100;
		List<InlineQueryResultArticle> result = new ArrayList<>();
		
		for (int i = 1; i <= 3; i++) {

			String text = facultyRusName + " 1" + "-" + (currentYear - i);

			InputTextMessageContent inputContent = InputTextMessageContent.builder()
					.messageText(
							BotMessages.SUCCESS_APPLY_FACULTY.getMessage() + " " + text)
					.build();

			InlineQueryResultArticle article = InlineQueryResultArticle.builder()
					.title(text)
					.id(text)
					.inputMessageContent(inputContent)
					.build();

			result.add(article);
		}
		return result;
	}
	
	private List<InlineQueryResultArticle> getInlineQueryResultsByESSS(
			String facultyRusName)  {
		
		int currentYear = LocalDate.now().getYear() % 100;
		List<InlineQueryResultArticle> result = new ArrayList<>();
		
		for (int i = 1; i <= 3; i++)
			for (int j = 1; j <= 4; j++) {

				String text = facultyRusName + " " + j + "-" + (currentYear - i);

				InputTextMessageContent inputContent = InputTextMessageContent.builder()
						.messageText(
								BotMessages.SUCCESS_APPLY_FACULTY.getMessage() + " " + text)
						.build();

				InlineQueryResultArticle article = InlineQueryResultArticle.builder()
						.title(text)
						.id(text)
						.inputMessageContent(inputContent)
						.build();

				result.add(article);
			}
		return result;
	}
	
	private List<InlineQueryResultArticle> getInlineQueryResultsByPKSOrKS(
			String facultyRusName) {
		
		int currentYear = LocalDate.now().getYear() % 100;
		List<InlineQueryResultArticle> result = new ArrayList<>();
		
		for (int i = 1; i <= 3; i++) {

			String text = facultyRusName + " " + i + "-" + (currentYear - 1) ;

			InputTextMessageContent inputContent = InputTextMessageContent.builder()
					.messageText(
							BotMessages.SUCCESS_APPLY_FACULTY.getMessage() + " " + text)
					.build();

			InlineQueryResultArticle article = InlineQueryResultArticle.builder()
					.title(text)
					.id(text)
					.inputMessageContent(inputContent)
					.build();

			result.add(article);
		}
		
		for (int i = 2; i <= 3; i++)
			for (int j = 1; j <= 2; j++) {
				String text = facultyRusName + " " + j + "-" + (currentYear - i);

				InputTextMessageContent inputContent = InputTextMessageContent.builder()
						.messageText(
								BotMessages.SUCCESS_APPLY_FACULTY.getMessage() + " " + text)
						.build();

				InlineQueryResultArticle article = InlineQueryResultArticle.builder()
						.title(text)
						.id(text)
						.inputMessageContent(inputContent)
						.build();

				result.add(article);
			}
		return result;
	}
}