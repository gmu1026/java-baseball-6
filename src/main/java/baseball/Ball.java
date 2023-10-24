package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Ball {
    private static final int BALLS_SIZE = 3;
    private List<Integer> balls;

    public Ball(List<Integer> balls) {
        validateSize(balls);
        validateDuplicateBall(balls);

        this.balls = balls;
    }

    private void validateSize(List<Integer> balls) {
        if (balls.size() != BALLS_SIZE) {
            throw new IllegalArgumentException("볼의 개수는 3개만 가능합니다.");
        }
    }

    private void validateDuplicateBall(List<Integer> balls) {
        Set<Integer> ballsToSet = new HashSet<>(balls);
        if (ballsToSet.size() != BALLS_SIZE) {
            throw new IllegalArgumentException("중복된 볼은 허용하지 않습니다.");
        }
    }

    public CompareResult compareBall(Ball targetBall) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < BALLS_SIZE; i++) {
            if (this.balls.contains(targetBall.balls.get(i))) {
                ballCount++;
            }

            if (this.balls.get(i).equals(targetBall.balls.get(i))) {
                strikeCount++;
                ballCount--;
            }
        }

        return new CompareResult(strikeCount, ballCount);
    }
}
