package hello.core.xml;

import hello.core.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {
    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }
}
