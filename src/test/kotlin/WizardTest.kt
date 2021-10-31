import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class WizardTest {

    var wizard = Wizard()

    @BeforeEach
    fun setUp() {
        wizard = Wizard()
    }

    @Test
    fun testTakeAndHealDamage(){
        wizard.takeDamage(40)
        assertEquals(60, wizard.healthPoints)
        wizard.castHealSpell()
        assertEquals(90, wizard.healthPoints)
    }

    @Test
    fun testHealOverFull(){
        wizard.takeDamage(10)
        assertEquals(90, wizard.healthPoints)
        wizard.castHealSpell()
        assertEquals(100, wizard.healthPoints)
    }

    @Test
    fun testNotEnoughMP(){
        wizard.takeDamage(90)
        wizard.castHealSpell()
        wizard.castHealSpell()
        wizard.castHealSpell()
        assertEquals(10, wizard.magicPoints)
        assertEquals(70, wizard.healthPoints)
    }

    @Test
    fun testDeath(){
        wizard.takeDamage(wizard.maxHealthPoints)
        assert(wizard.dead)
        wizard.castHealSpell()
        assert(wizard.healthPoints == 0)
    }
}