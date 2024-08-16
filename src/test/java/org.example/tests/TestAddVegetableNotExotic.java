package org.example.tests;

import org.example.pom.ProductsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddVegetableNotExotic extends BaseTest{

    @Test
    void testAddVegetableNotExotic() throws InterruptedException {
        driver.get("http://localhost:8080/food");
        ProductsPage productsPage = new ProductsPage(driver, wait);

        // Шаг 1: Нажать кнопку «Добавить» в левом нижнем углу страницы
        productsPage.clickAddButton();
        Thread.sleep(3000);
        // Ожидаемый результат: Открывается окно добавления товара
        assertEquals("Добавление товара", productsPage.openModWindowAddingProduct(),
                "Окно добавления товара не открылось");

        // Шаг 2: Ввести «Помидор-4^S)j» в поле «Наименование» в окне добавления товара
        String productVegetableName = "Помидор-4^S)j";
        productsPage.nameProductInput(productVegetableName);
        Thread.sleep(3000);
        // Ожидаемый результат: В поле «Наименование» в окне добавления товара отображено «Помидор-4^S)j»
        assertEquals("Помидор-4^S)j", productsPage.displayingProductName(),
                "Помидор-4^S)j не отобразилось");

        // Шаг 3: Нажать в поле «Тип» на выпадающий список в окне добавления товара и выбрать вариант "Овощ"
        productsPage.clickSelectTypeField();
        Thread.sleep(3000);
        productsPage.clickSelectVegetableType();
        Thread.sleep(3000);
        // Ожидаемый результат: Поле «Тип» в окне добавления товара отображается «Овощ»
        assertEquals("Овощ", productsPage.displayingTypeFieldVegetable(),
                "Овощ не отобразился");

        // Шаг 4: Нажать на кнопку «Сохранить» синего цвета в правом нижнем углу в окне добавления товара
        productsPage.clickSaveButton();
        Thread.sleep(3000);
        // Ожидаемый результат: Осуществлен переход на страницу списка товаров
        assertEquals("Список товаров", productsPage.openWindowProductList(),
                "Переход на страницу списка товаров не выполнен");

        //Проверка появления товара Помидор-4^S)j на странице списка товаров
        assertEquals("Помидор-4^S)j", productsPage.displayingNameOfVegetableProduct(),
                "Товар Помидор-4^S)j не найден");
    }

}
