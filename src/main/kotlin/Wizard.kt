class Wizard {
    val maxHealthPoints = 100
    var healthPoints = maxHealthPoints
    val maxMagicPoints = 50
    var magicPoints = maxMagicPoints
    var dead = false

    fun takeDamage(damage: Int) {
        healthPoints -= damage
        dead = healthPoints <= 0
    }

    fun castHealSpell() {
        if (magicPoints >= 20 && healthPoints < maxHealthPoints && !dead){
            healthPoints += 30
            if (healthPoints > maxHealthPoints)
                healthPoints = maxHealthPoints
            magicPoints -= 20
        }
    }
}