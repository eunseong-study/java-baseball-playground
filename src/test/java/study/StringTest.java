package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringTest {
    
	@Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
	/**
	 * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
	 * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
	 */
	@Test
	void split() {
		String[] actual = "1,2".split(",");
		assertThat(actual).contains("2", "1");
		assertThat(actual).containsExactly("1", "2");

		String[] actual2 = "1".split(",");
		assertThat(actual2).contains("1");
		assertThat(actual2).containsExactly("1");
	}
	
	/**
	 * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
	 */
	@Test
	void subString() {
		String actual = "(1,2)";
		actual = actual.substring(1, actual.length()-1);
		assertThat(actual).isEqualTo("1,2");
	}
	/*
	 * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
	 * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
	 * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
	 */
	@Test
	@DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현")
	void chatAt() {
		String actual = "abc";

		assertThatThrownBy(() -> 
			actual.charAt(actual.length())
		).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range")
			.hasMessageContaining(String.valueOf(actual.length()));
		
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
		  .isThrownBy(() ->
			actual.charAt(actual.length())
		).withMessageMatching("String index out of range: \\d");		
	}
}
