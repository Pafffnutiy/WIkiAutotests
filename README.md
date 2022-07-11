Написаны автотесты для всех кейсов
    
Тесты находятся по пути: [app/src/androidTest/java/rg/wikipedia/FintechTests](https://github.com/Pafffnutiy/WIkiAutotests/tree/main/app/src/androidTest/java/org/wikipedia/FintechTests)

Они были проверены на следующих эмуляторах:
1. Pixel 5 API 29
2. Pixel 2 API 26
3. Pixel 3XL API 27

**Примечание 1:** для корректной работы тестов на эмуляторе должны быть установлены хотя бы Английский и Русский язык
_____________________________________________________________________
# Тест кейсы
1. Проверка перехода в браузер
    1. Открываем приложение
    2. Нажимаем на кнопку "Еще"
    3. Нажимаем кнопку "Пожертвовать"
    4. Проверяем, что случился переход на окно выбора браузера для открытия
2. Проверка настройки ленты по умолчанию
    1. Открываем приложение
    2. Нажимаем на кнопку "Еще"
    3. Нажимаем кнопку "Настройки"
    4. Нажимаем на кнопку "Настройки ленты"
    5. Проверяем, что каждый чек-бокс в состоянии checked
    6. Не забываем про правило один кейс — одна проверка :wink:

3. Проверка блоков на экране "О приложении"
    1. Открываем приложение
    2. Нажимаем "Еще" ﻿
    3. Нажимаем настройки
    4. Нажимаем на "О приложении "Википедия"
    5. Проверяем, что на экране есть блок "Авторы", "Переводчики" и "Лицензия"﻿

4. Проверка, что пароль скрывается, если нажать на глазик два раза
    1. Открываем приложение
    2. Нажимаем на кнопку «Еще»
    3. Нажимаем "Создать учетную запись"
    4. Заполняем поле пароля любимыми данными
    5. Нажимаем иконку "глазик"
    6. Проверяем что отображается введенный пароль
    7. Нажимаем иконку "глазик"
    8. Проверяем, что отображаются точки (пароль скрыт)
    
5. Проверка валидации поля установки пароля.
    1. Открываем приложение
    2. Нажимаем на кнопку «Еще»
    3. Нажимаем "Создать учетную запись"
    4. Заполняем форму, пароль вводим длиной, меньшей чем 8 символов
    5. Нажимаем на кнопку далее
    6. Проверяем, что у поля "пароль" красный заголовок
    7. Проверяем, что появилось красное сообщение об ошибке: "Пароль должен состоять не менее чем из 8 символов"
    
6. Проверка добавления статьи в избранное
    1. Открываем приложение
    2. Вводим в поле поиска "Тинькофф премьер лига"
    3. Открываем статью
    4. Нажимаем на иконку "Сохранить"
    5. Нажимаем в диалоговом окне "добавить в список"
    6. В новом окне вводим название списка (любое) и нажимаем ок
    7. Нажимаем кнопку "Назад"
    8. Нажимаем кнопку "Сохранено"
    9. Нажимаем на наш список
    10. Проверяем, что название статьи отображается в нем
    
7. Проверка удаления статьи из избранного
    1. Провести все шаги из кейса 6
    2. Лонг-тап по статье из списка
    3. Выбираем кнопку "удалить"
    4. Проверяем, что появляется уведомление о том, что список удален
