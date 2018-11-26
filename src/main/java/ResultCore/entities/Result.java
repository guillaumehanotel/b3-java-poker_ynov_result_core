package ResultCore.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    public Result(Integer userId) {
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "user_id", unique = true)
    private Integer userId;

    @Column(name = "nb_games_played")
    private Integer nbGamesPlayed = 0;

    @Column(name = "nb_games_won")
    private Integer nbGamesWon = 0;

    @Column(name = "nb_round_played")
    private Integer nbRoundPlayed = 0;

    @Column(name = "nb_round_won")
    private Integer nbRoundWon = 0;

    @Column(name = "total_earned_money")
    private Integer totalEarnedMoney = 0;

    @Column(name = "biggest_pot_won")
    private Integer biggestPotWon = 0;

}
