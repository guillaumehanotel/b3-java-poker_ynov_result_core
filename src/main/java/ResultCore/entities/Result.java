package ResultCore.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "money_won")
    private Integer moneyWon = 0;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Paris")
    private Date date;

    @Column(name = "combinaison")
    private String combinaison;

    public Result(Integer userId, Integer gameId, Integer moneyWon, Date date, String combinaison) {
        this.userId = userId;
        this.gameId = gameId;
        this.moneyWon = moneyWon;
        this.date = date;
        this.combinaison = combinaison;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", userId=" + userId +
                ", gameId=" + gameId +
                ", moneyWon=" + moneyWon +
                ", date=" + date +
                ", combinaison='" + combinaison + '\'' +
                '}';
    }
}
