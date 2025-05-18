import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
public class RspChallengeMode{    
    public static void main(String[]args){
        boolean play = true;
        Scanner s = new Scanner(System.in);
        Random random = new Random();
        int user_Pt = 300;
        int com_Pt = 300;
        System.out.println("가위바위보 포인트 배팅 게임");
        System.out.println("[User]:" + user_Pt + "pt");
        System.out.println("[Com]:" + com_Pt + "pt");
        while (play) {
            int com_bet;
            if (com_Pt > 0) {
                com_bet = random.nextInt(com_Pt) + 1;
            } else {
                System.out.println("[Com]의 포인트가 모두 소진되었습니다.");
                play = false;
                break;
            }
            System.out.println("[Com]이" + com_bet + "pt를 걸었습니다!");
            int user_bet = 0;
            while (true) {
                System.out.print("배팅할 포인트를 입력해주세요.");
                try {
                    user_bet = s.nextInt();
                    if (user_bet >= 1 && user_bet <= user_Pt) {
                    break;
                    } else {
                        System.out.println("잘못된 입력입니다. 보유 하고 있는 Point 내에서 배팅해주세요.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력해주세요");
                    s.next();
                }
            }
            user_Pt = user_Pt - user_bet;
            com_Pt = com_Pt - com_bet;
            int pot_bet = com_bet + user_bet;
            int user_num = 0;
            while (true) {
                System.out.print("1(가위) /2(바위) /3(보) 중에서 숫자 하나를 선택해서 입력하세요.:");
                try {
                    user_num = s.nextInt();
                    if (user_num >= 1 && user_num <= 3) {
                    break;
                    } else {
                        System.out.println("잘못된 입력입니다. 1(가위) /2(바위) /3(보) 중에서 숫자 하나를 입력해야 합니다.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력해주세요.");
                    s.next();
                }
            }
            String user_choice;
            switch (user_num) {
                case 1: user_choice = "가위"; break;
                case 2: user_choice = "바위"; break;
                default : user_choice = "보"; break;
            }
            System.out.println("User가 입력한 값 :"+user_num + "->" + user_choice);
            int com_num = random.nextInt(1,4);
            String com_choice;
            switch (com_num) {
                case 1: com_choice = "가위"; break;
                case 2: com_choice = "바위"; break;
                default: com_choice = "보"; break;
            }
            System.out.println("CPU가 고른 숫자: " + com_num + "->" + com_choice);
            if ((user_num == 1 && com_num == 3) || 
                (user_num == 2 && com_num == 1) || 
                (user_num == 3 && com_num == 2)) {
                System.out.println("User 승리!");
                System.out.println("[User]는" + pot_bet + "pt 획득 하셨습니다.");
                user_Pt = user_Pt + pot_bet;
            } else if (user_num == com_num){
                System.out.println("비겼습니다. 포인트는 다시 돌려드립니다.");
                user_Pt = user_Pt + user_bet;
                com_Pt = com_Pt + com_bet;
            } else {
                System.out.println("COM 승리!");
                System.out.println("[User]는" + user_bet + "pt를 잃었습니다.");
                com_Pt = com_Pt + pot_bet;
            }
            System.out.println("[User] 잔여 포인트:" + user_Pt + "pt");
            System.out.println("[Com] 잔여 포인트:" + com_Pt + "pt");
            if (user_Pt <= 0) {
                System.out.println("[User] 포인트가 모두 소진되었습니다.");
                play = false;
            } else if (com_Pt <= 0) {
                System.out.println("[Com] 포인트가 모두 소진되었습니다.");
                play = false;
            }
            while (true) {
                System.out.print("게임을 계속 하시겠습니까? (y/n) : ");
                String user_answer = s.next();
                if (user_answer.equalsIgnoreCase("y")) {
                break;
                } else if (user_answer.equalsIgnoreCase("n")) {
                play = false;
                break;
                } else {
                    System.out.println("잘못된 입력입니다. y/n 중에서 하나를 입력해주세요.");
                }
            }
        }
        s.close();
        System.out.println("[User] 포인트:" + user_Pt + "pt");
        System.out.println("[Com] 포인트:" + com_Pt + "pt");
        if (user_Pt > com_Pt){
            System.out.println("[User] 최종 승리!");
        } else if (user_Pt < com_Pt) {
            System.out.println("[Com] 최종 승리!");
        } else {
            System.out.println("무승부!");
        }
        System.out.println("게임을 종료합니다.");
        
    }
}