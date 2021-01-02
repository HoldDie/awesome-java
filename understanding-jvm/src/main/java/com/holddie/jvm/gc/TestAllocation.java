package com.holddie.jvm.gc;

/**
 * 测试分区垃圾收集
 *
 * @author HoldDie
 * @version 1.0
 * @date 2020/11/18 2:05 PM
 */
public class TestAllocation {
	public static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
//		testAllocation();
//		testPretenureSizeThreshold();
//		testTenuringThreshold();
		testTenuringThreshold2();
	}

	/**
	 * 对象优先在 Eden 分配
	 * <p>
	 * -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * <pre>
	 * [GC (Allocation Failure) [DefNew: 7852K->390K(9216K), 0.0045227 secs] 7852K->6534K(19456K), 0.0045465 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	 *
	 * Heap
	 *  def new generation   total 9216K, used 4650K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
	 *   eden space 8192K,  52% used [0x00000007bec00000, 0x00000007bf0290f0, 0x00000007bf400000)
	 *   from space 1024K,  38% used [0x00000007bf500000, 0x00000007bf561a58, 0x00000007bf600000)
	 *   to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
	 *  tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
	 *    the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
	 *  Metaspace       used 2972K, capacity 4496K, committed 4864K, reserved 1056768K
	 *   class space    used 326K, capacity 388K, committed 512K, reserved 1048576K
	 * </pre>
	 *
	 * @date 2020/11/18  2:23 PM
	 * @author HoldDie
	 */
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB]; // Minor GC
	}

	/**
	 * 大对象直接进老年区
	 * <p>
	 * -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
	 * <pre>
	 * Heap
	 *  def new generation   total 9216K, used 1872K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
	 *   eden space 8192K,  22% used [0x00000007bec00000, 0x00000007bedd40e0, 0x00000007bf400000)
	 *   from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
	 *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
	 *  tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
	 *    the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00010, 0x00000007bfa00200, 0x00000007c0000000)
	 *  Metaspace       used 2950K, capacity 4496K, committed 4864K, reserved 1056768K
	 *   class space    used 320K, capacity 388K, committed 512K, reserved 1048576K
	 * </pre>
	 *
	 * @date 2020/11/18  2:25 PM
	 * @author HoldDie
	 */
	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB]; //直接分配在老年代中
	}

	/**
	 * 长期存活对象直接进老年区
	 * <p>
	 * -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
	 *
	 * <pre>
	 *     [GC (Allocation Failure) [DefNew
	 * Desired survivor size 524288 bytes, new threshold 1 (max 1)
	 * - age   1:     662040 bytes,     662040 total
	 * : 6060K->646K(9216K), 0.0038970 secs] 6060K->4742K(19456K), 0.0039276 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	 * [GC (Allocation Failure) [DefNew
	 * Desired survivor size 524288 bytes, new threshold 1 (max 1)
	 * - age   1:       2640 bytes,       2640 total
	 * : 4824K->2K(9216K), 0.0011794 secs] 8920K->4730K(19456K), 0.0012003 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	 * Heap
	 *  def new generation   total 9216K, used 4235K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
	 *   eden space 8192K,  51% used [0x00000007bec00000, 0x00000007bf022510, 0x00000007bf400000)
	 *   from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400a50, 0x00000007bf500000)
	 *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
	 *  tenured generation   total 10240K, used 4727K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
	 *    the space 10240K,  46% used [0x00000007bf600000, 0x00000007bfa9de58, 0x00000007bfa9e000, 0x00000007c0000000)
	 *  Metaspace       used 2979K, capacity 4496K, committed 4864K, reserved 1056768K
	 *   class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
	 * </pre>
	 * <p>
	 * -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=4 -XX:+PrintTenuringDistribution
	 *
	 * <pre>
	 *    [GC (Allocation Failure) [DefNew
	 * Desired survivor size 524288 bytes, new threshold 1 (max 4)
	 * - age   1:     674224 bytes,     674224 total
	 * : 6060K->658K(9216K), 0.0036463 secs] 6060K->4754K(19456K), 0.0036680 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	 * [GC (Allocation Failure) [DefNew
	 * Desired survivor size 524288 bytes, new threshold 4 (max 4)
	 * - age   1:      12488 bytes,      12488 total
	 * : 4836K->12K(9216K), 0.0010003 secs] 8932K->4751K(19456K), 0.0010265 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	 * Heap
	 *  def new generation   total 9216K, used 4245K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
	 *   eden space 8192K,  51% used [0x00000007bec00000, 0x00000007bf022690, 0x00000007bf400000)
	 *   from space 1024K,   1% used [0x00000007bf400000, 0x00000007bf4030c8, 0x00000007bf500000)
	 *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
	 *  tenured generation   total 10240K, used 4739K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
	 *    the space 10240K,  46% used [0x00000007bf600000, 0x00000007bfaa0e70, 0x00000007bfaa1000, 0x00000007c0000000)
	 *  Metaspace       used 2999K, capacity 4496K, committed 4864K, reserved 1056768K
	 *   class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
	 * </pre>
	 *
	 * @date 2020/11/18  2:31 PM
	 * @author HoldDie
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		// 什么时候进入老年代决定于XX:MaxTenuringThreshold设置
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}

	/**
	 * -verbose:gc -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
	 * <p>
	 * 测试不注释 allocation1 = new byte[_1MB / 4];
	 * <pre>
	 *     [GC (Allocation Failure) [DefNew
	 * Desired survivor size 524288 bytes, new threshold 1 (max 15)
	 * - age   1:     928368 bytes,     928368 total
	 * : 6316K->906K(9216K), 0.0034924 secs] 6316K->5002K(19456K), 0.0035146 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	 * [GC (Allocation Failure) [DefNew
	 * Desired survivor size 524288 bytes, new threshold 15 (max 15)
	 * - age   1:      20736 bytes,      20736 total
	 * : 5084K->20K(9216K), 0.0010366 secs] 9180K->5008K(19456K), 0.0010509 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	 * Heap
	 *  def new generation   total 9216K, used 4253K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
	 *   eden space 8192K,  51% used [0x00000007bec00000, 0x00000007bf022620, 0x00000007bf400000)
	 *   from space 1024K,   1% used [0x00000007bf400000, 0x00000007bf405100, 0x00000007bf500000)
	 *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
	 *  tenured generation   total 10240K, used 4987K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
	 *    the space 10240K,  48% used [0x00000007bf600000, 0x00000007bfadef10, 0x00000007bfadf000, 0x00000007c0000000)
	 *  Metaspace       used 3012K, capacity 4496K, committed 4864K, reserved 1056768K
	 *   class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
	 * </pre>
	 * <p>
	 * 测试注释 allocation1 = new byte[_1MB / 4];
	 * <pre>
	 *    [GC (Allocation Failure) [DefNew
	 * Desired survivor size 524288 bytes, new threshold 1 (max 15)
	 * - age   1:     686912 bytes,     686912 total
	 * : 6225K->670K(9216K), 0.0037288 secs] 6225K->4766K(19456K), 0.0037509 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	 * [GC (Allocation Failure) [DefNew
	 * Desired survivor size 524288 bytes, new threshold 15 (max 15)
	 * - age   1:        984 bytes,        984 total
	 * : 4850K->0K(9216K), 0.0009153 secs] 8946K->4732K(19456K), 0.0009304 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	 * Heap
	 *  def new generation   total 9216K, used 4233K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
	 *   eden space 8192K,  51% used [0x00000007bec00000, 0x00000007bf0223f0, 0x00000007bf400000)
	 *   from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf4003d8, 0x00000007bf500000)
	 *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
	 *  tenured generation   total 10240K, used 4731K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
	 *    the space 10240K,  46% used [0x00000007bf600000, 0x00000007bfa9ee50, 0x00000007bfa9f000, 0x00000007c0000000)
	 *  Metaspace       used 3018K, capacity 4496K, committed 4864K, reserved 1056768K
	 *   class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
	 * </pre>
	 *
	 * @date 2020/11/18  2:53 PM
	 * @author HoldDie
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[_1MB / 4]; // allocation1+allocation2大于survivo空间一半
		allocation3 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation4 = new byte[4 * _1MB];
	}
}
