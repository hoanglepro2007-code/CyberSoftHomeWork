import java.util.ArrayList;

// 1. Interface Healing (Chứng chỉ y tá)
interface HealingSkill {
    void heal(ArrayList<GameCharacter> team);
}

// 2. Abstract Class GameCharacter
abstract class GameCharacter {
    private String charname;
    protected int hp;
    protected int attackPower;

    public GameCharacter(String charname, int hp, int attackPower) {
        this.charname = charname;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public abstract void attack(GameCharacter target);

    public void takeDamage(int amount) {
        this.hp -= amount;
        if (this.hp < 0) this.hp = 0;
        System.out.println(this.charname + " lose " + amount + "HP. HP remain: " + this.hp);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public String getName() {
        return charname;
    }
}

// 3. Class Warrior
class Warrior extends GameCharacter {
    public Warrior(String charnamne, int hp, int attackPower) {
        super(charnamne, hp, attackPower);
    }

    @Override
    public void attack(GameCharacter target) {
        double luck = Math.random();
        if (luck < 0.4) {
            System.out.println("CRITICAL! " + this.getName() + " x2 DAMAGE!");
            target.takeDamage(this.attackPower * 2);
        } else {
            System.out.println(this.getName() + " attacks!");
            target.takeDamage(this.attackPower);
        }
    }
}

// 4. Class Mage
class Mage extends GameCharacter {
    public Mage(String charname, int hp, int attackPower) {
        super(charname, hp, attackPower);
    }

    @Override
    public void attack(GameCharacter target) {
        if (this.hp > 5) {
            this.hp -= 5;
            System.out.println(this.getName() + " sacrifices 5 HP to cast Fireball!");
            target.takeDamage(this.attackPower + 10);
        } else {
            System.out.println(this.getName() + " is exhausted...");
            target.takeDamage(this.attackPower / 2);
        }
    }
}

// 5. Class Priest (Đã sửa logic Heal chuẩn)
class Priest extends GameCharacter implements HealingSkill {
    public Priest(String charname, int hp, int attackPower) {
        super(charname, hp, attackPower);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(this.getName() + " attacks lightly.");
        target.takeDamage(this.attackPower);
    }

    @Override
    public void heal(ArrayList<GameCharacter> team) {
        // Tìm người thấp máu nhất
        GameCharacter lowestHPchar = team.get(0);
        for (int i = 1; i < team.size(); i++) {
            if (team.get(i).hp < lowestHPchar.hp) {
                lowestHPchar = team.get(i);
            }
        }

        // Kiểm tra xem có cần hồi không (Giả sử Max HP là 100)
        if (lowestHPchar.hp < 100) {
            int healAmount = 20;
            lowestHPchar.hp += healAmount;
            if (lowestHPchar.hp > 100) lowestHPchar.hp = 100;

            System.out.println("🌿 " + this.getName() + " HEALS " + lowestHPchar.getName());
            System.out.println("--> " + lowestHPchar.getName() + " HP: " + lowestHPchar.hp);
        } else {
            System.out.println("Team khỏe! " + this.getName() + " không hồi máu.");
        }
    }
}

// 6. Main Class
public class rpg { 
    public static void main(String[] args) {
        ArrayList<GameCharacter> teamA = new ArrayList<>();
        ArrayList<GameCharacter> teamB = new ArrayList<>();

        // Setup Team A (Demacia)
        teamA.add(new Warrior("Garen", 100, 10));
        teamA.add(new Mage("Lux", 80, 15));
        teamA.add(new Warrior("Jarvan IV", 100, 10));
        teamA.add(new Priest("Sona", 100, 3));

        // Setup Team B (Noxus)
        teamB.add(new Warrior("Sion", 100, 10));
        teamB.add(new Mage("Leblanc", 80, 15));
        teamB.add(new Warrior("Darius", 100, 10));
        teamB.add(new Priest("Briar", 100, 3));

        System.out.println("=== TRẬN CHIẾN BẮT ĐẦU ===");

        // VÒNG LẶP CHIẾN ĐẤU
        while (teamA.size() > 0 && teamB.size() > 0) {
            
            // 1. Chọn người ngẫu nhiên
            int indexA = (int) (Math.random() * teamA.size());
            int indexB = (int) (Math.random() * teamB.size());
            GameCharacter fighterA = teamA.get(indexA);
            GameCharacter fighterB = teamB.get(indexB);

            // 2. LƯỢT CỦA TEAM A
            if (fighterA instanceof Priest) {
                ((Priest) fighterA).heal(teamA); // Priest thì hồi máu
            } else {
                fighterA.attack(fighterB); // Còn lại thì đánh
            }

            // Kiểm tra B chết chưa?
            if (!fighterB.isAlive()) {
                System.out.println("💀 " + fighterB.getName() + " has been eliminated!");
                teamB.remove(indexB);
            } 
            else { 
                // 3. LƯỢT CỦA TEAM B (Phản công)
                if (fighterB instanceof Priest) {
                    ((Priest) fighterB).heal(teamB); // Priest thì hồi máu
                } else {
                    fighterB.attack(fighterA); // Sửa lỗi: Chỉ đánh 1 lần thôi!
                    
                    // Kiểm tra A chết chưa?
                    if (!fighterA.isAlive()) {
                        System.out.println("💀 " + fighterA.getName() + " has been eliminated!");
                        teamA.remove(indexA);
                    }
                }
            }
            System.out.println("----------------------------------");
        } // Kết thúc While

        // TỔNG KẾT
        if (teamA.isEmpty()) {
            System.out.println("🏆 TEAM NOXUS (B) WINS!");
        } else {
            System.out.println("🏆 TEAM DEMACIA (A) WINS!");
        }
    }
}