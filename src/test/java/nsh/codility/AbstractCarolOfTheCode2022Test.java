package nsh.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import java.time.Duration;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class AbstractCarolOfTheCode2022Test {
	abstract CarolOfTheCode2022Interface getTestObject();

	CarolOfTheCode2022Interface testObject;

	@BeforeEach
	void setup() {
		testObject = getTestObject();
	}

	@ParameterizedTest
	@MethodSource
	void test_samples(int E, String[] A) {
		assertEquals(E, testObject.solution(A));
	}

	static Stream<Arguments> test_samples() {
		return Stream.of( //
				Arguments.of(1, new String[] {"RGBW", "GBRW"}), //
				Arguments.of(4, new String[] {"WBGR", "WBGR", "WRGB", "WRGB", "RBGW"}), //
				Arguments.of(2, new String[] {"RBGW", "GBRW", "RWGB", "GBRW"}), //
				Arguments.of(2, new String[] {"GBRW", "RBGW", "BWGR", "BRGW"}));
	}

	@ParameterizedTest
	@MethodSource
	void test_1_tile(int E, String[] A) {
		assertEquals(E, testObject.solution(A));
	}

	static Stream<Arguments> test_1_tile() {
		return Stream.of( //
				Arguments.of(0, new String[] {"RGBW"}), //
				Arguments.of(0, new String[] {"WBGR"}), //
				Arguments.of(0, new String[] {"RBGW"}), //
				Arguments.of(0, new String[] {"GBRW"}));
	}

	@ParameterizedTest
	@MethodSource
	void test_identical_tiles(int E, String[] A) {
		assertEquals(E, testObject.solution(A));
	}

	static Stream<Arguments> test_identical_tiles() {
		return Stream.of( //
				Arguments.of(4, new String[] {"RGBW", "RGBW", "RGBW", "RGBW"}), //
				Arguments.of(4, new String[] {"WBGR", "WBGR", "WBGR", "WBGR"}), //
				Arguments.of(4, new String[] {"RBGW", "RBGW", "RBGW", "RBGW"}), //
				Arguments.of(4, new String[] {"GBRW", "GBRW", "GBRW", "GBRW"}), //
				Arguments.of(10, new String[] {"GBRW", "GBRW", "GBRW", "GBRW", "GBRW", "GBRW", "GBRW",
						"GBRW", "GBRW", "GBRW"}));
	}

	@ParameterizedTest
	@MethodSource
	void test_repeating_tiles(int E, String[] A) {
		assertEquals(E, testObject.solution(A));
	}

	static Stream<Arguments> test_repeating_tiles() {
		return Stream.of( //
				Arguments.of(4, new String[] {"RGBW", "GBRW", "RGBW", "GBRW"}));
	}

	private Duration getTimeoutDuration() {
		return Duration.ofMillis(2000);
	}

	@Test
	void test_long_1() {
		int L = 100_000;
		String[] A = new String[L];
		for (int i = 0; i < L; i++) {
			A[i] = "GBRW";
		}
		int E = L;
		assertTimeoutPreemptively(getTimeoutDuration(), () -> assertEquals(E, testObject.solution(A)));
	}
}
