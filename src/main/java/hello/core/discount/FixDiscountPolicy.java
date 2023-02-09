package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      // 1000원 할인
      return 1000;
    } else {
      return 0;
    }
  }
}
