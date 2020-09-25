package com.com470.coffeeMackerMockitoApp;

import com.com470.coffeeMackerMockitoApp.exceptions.InventoryException;
import com.com470.coffeeMackerMockitoApp.exceptions.RecipeException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CoffeeMakerTest {

    /**
     * The object under test.
     */
    private CoffeeMaker coffeeMaker;
    private RecipeBook recipeBook;

    // Sample recipes to use in testing.
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;
    private Recipe recipeEdit;

    /**
     * El libro de recetas aplastado.
     */
    private RecipeBook libroRecetasStub;

    private Inventory inventario;

    @Before
    public void Inicializar() throws RecipeException {
        coffeeMaker = new CoffeeMaker();

        //Set up for r1
        recipe1 = new Recipe();
        recipe1.setName("Coffee");
        recipe1.setAmtChocolate("0");
        recipe1.setAmtCoffee("3");
        recipe1.setAmtMilk("1");
        recipe1.setAmtSugar("1");
        recipe1.setPrice("50");

        //Set up for r2
        recipe2 = new Recipe();
        recipe2.setName("Mocha");
        recipe2.setAmtChocolate("20");
        recipe2.setAmtCoffee("3");
        recipe2.setAmtMilk("1");
        recipe2.setAmtSugar("1");
        recipe2.setPrice("75");

        //Set up for r3
        recipe3 = new Recipe();
        recipe3.setName("Latte");
        recipe3.setAmtChocolate("0");
        recipe3.setAmtCoffee("3");
        recipe3.setAmtMilk("3");
        recipe3.setAmtSugar("1");
        recipe3.setPrice("100");

        //Set up for r4
        recipe4 = new Recipe();
        recipe4.setName("Hot Chocolate");
        recipe4.setAmtChocolate("4");
        recipe4.setAmtCoffee("0");
        recipe4.setAmtMilk("1");
        recipe4.setAmtSugar("1");
        recipe4.setPrice("65");
    }

    @Test
    public void testAddInventory() throws InventoryException {
        coffeeMaker.addInventory("4", "7", "0", "9");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException() throws InventoryException {
        coffeeMaker.addInventory("4", "-1", "asdf", "3");
    }

    @Test
    public void testHacerCafe() {
        coffeeMaker.addRecipe(recipe1);
        assertEquals(25, coffeeMaker.makeCoffee(0, 75));
    }

    @Test
    public void testHacerCafe2() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);

        coffeeMaker.makeCoffee(0, 75);
        assertTrue(true);
        coffeeMaker.makeCoffee(1, 40);
        assertTrue(true);
        coffeeMaker.makeCoffee(0, 0);
        assertTrue(true);
        coffeeMaker.makeCoffee(2, 0);
        assertTrue(true);
        coffeeMaker.makeCoffee(1, 75);
        assertTrue(true);

    }

    @Test
    public void testEliminarCafe() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.deleteRecipe(0);
        String auxDR1 = coffeeMaker.deleteRecipe(0);
        assertNull(auxDR1);
    }

    @Test
    public void testEditarCafe() {
        coffeeMaker.addRecipe(recipe1);
        String auxDR1 = coffeeMaker.editRecipe(0, recipe1);
        String auxDR2 = coffeeMaker.editRecipe(0, recipe1);
        assertEquals(auxDR1, auxDR2);
    }

    @Test
    public void testVerificarInventario() {
        String out = coffeeMaker.checkInventory().toString();
        assertEquals("Coffee: " + 15 + "\n" + "Milk: " + 15 + "\n" + "Sugar: " + 15 + "\n" + "Chocolate: " + 15 + "\n", out);
    }

    @Test
    public void testAgregarReceta() {
        coffeeMaker = new CoffeeMaker();
        boolean resultadoUno = coffeeMaker.addRecipe(recipe1);
        boolean resultadoDos = coffeeMaker.addRecipe(recipe2);
        boolean resultadoTres = coffeeMaker.addRecipe(recipe3);
        boolean resultadoCuatro = coffeeMaker.addRecipe(recipe4);

        assertThat(resultadoUno, is(true));
        assertThat(resultadoDos, is(true));
        assertThat(resultadoTres, is(true));
        assertThat(resultadoCuatro, is(false));
    }

    @Test
    public void testEditarReceta() {
        coffeeMaker.addRecipe(recipe2);
        assertTrue(true);
        coffeeMaker.editRecipe(0, recipe1);
        assertTrue(true);

    }

    @Test
    public void testEditarReceta2() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        coffeeMaker.editRecipe(1, recipe2);
        assertTrue(true);
    }

    @Test
    public void testEliminarReceta() {
        boolean statusAdd = coffeeMaker.addRecipe(recipe1);
        assertTrue(statusAdd);
        String statusDeleted = coffeeMaker.deleteRecipe(0);
        assertTrue(statusDeleted == recipe1.getName());

    }

    @Test
    public void testCompraDeBebidas() {
        int amountPaid = 42;
        int change = coffeeMaker.makeCoffee(-1, 42);
        assertEquals(amountPaid, change);
    }
}
