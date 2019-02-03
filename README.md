Web-приложение для просмотра бд сети связи.
===
Используемые технологии: Java 8, JSF, EJB, Wildfly, Maven, Hibernate, MySQL.
***
Приложение состоит из двух страниц:
1. Отображение всех узлов в бд.
2. Отображение данных о конкретном узле.
Для перехода на вторую страницу нажать на узел, представленный на первой странице. Для отображение связей нажать кнопку "Показать связи".
***
Конфигурация Hibernate для MySQL представлена в файле src/main/resources/META-INF/persistence.xml.
***
Для запуска выполнить команду **mvn clean package wildfly:deploy** при запущенном Wildfly.
