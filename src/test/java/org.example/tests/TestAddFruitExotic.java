package org.example.tests;

import org.example.pom.ProductsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddFruitExotic extends BaseTest {
    @Test
    void testAddFruitExotic() throws InterruptedException {
        driver.get("http://localhost:8080/food");
        ProductsPage productsPage = new ProductsPage(driver, wait);

        // Шаг 1: Нажать кнопку «Добавить» в левом нижнем углу страницы
        productsPage.clickAddButton();
        Thread.sleep(3000);
        // Ожидаемый результат: Открывается окно добавления товара
        assertEquals("Добавление товара", productsPage.openModWindowAddingProduct(),
                "Окно добавления товара не открылось");

        // Шаг 2: Ввести «Авокадо_5@Gg» в поле «Наименование» в окне добавления товара
        String productFruitName = "Авокадо_5@Gg";
        productsPage.nameProductInput(productFruitName);
        Thread.sleep(3000);
        // Ожидаемый результат: В поле «Наименование» в окне добавления товара отображено «Авокадо_5@Gg»
        assertEquals("Авокадо_5@Gg", productsPage.displayingProductName(),
                "Авокадо_5@Gg не отобразилось");

        // Шаг 3: Нажать в поле «Тип» на выпадающий список в окне добавления товара и выбрать вариант "Фрукт"
        productsPage.clickSelectTypeField();
        Thread.sleep(3000);
        productsPage.clickSelectTypeFruit();
        Thread.sleep(3000);
        // Ожидаемый результат: Поле «Тип» в окне добавления товара отображается «Фрукт»
        assertEquals("Фрукт", productsPage.displayingTypeField(),
                "Фрукт не отобразился");

        // Шаг 4: Нажать на чекбокс в поле "Экзотический" в окне добавления товара
        productsPage.clickSelectExotic();
        Thread.sleep(3000);
        // Ожидаемый результат: Чекбокс отображает белую галочку на синем фоне
        assertTrue(productsPage.checkSelectExotic(), "Чекбокс не отображает галочку");

        // Шаг 5: Нажать на кнопку «Сохранить» синего цвета в правом нижнем углу в окне добавления товара
        productsPage.clickSaveButton();
        Thread.sleep(3000);
        // Ожидаемый результат: Осуществлен переход на страницу списка товаров
        assertEquals("Список товаров", productsPage.openWindowProductList(),
                "Переход на страницу списка товаров не выполнен");

        //Проверка появления товара Авокадо_5@Gg на странице списка товаров
        assertEquals("Авокадо_5@Gg", productsPage.displayingNameOfProduct(),
                "Товар Авокадо_5@Gg не найден");
    }

}