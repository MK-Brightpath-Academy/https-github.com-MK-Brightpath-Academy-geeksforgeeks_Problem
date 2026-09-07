<h2><a href="https://www.geeksforgeeks.org/problems/string-comparison5858/1?page=13&category=Arrays%2CStrings%2CJava%2CLinked%20List&company=Amazon%2CMicrosoft%2CGoogle%2CFlipkart&sortBy=submissions">Special String Comparison</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 14pt;">Given two strings <strong>s1</strong> and <strong>s2</strong> and compare them on the basis of a special priority order where we have "<strong>ng</strong>" between n and o.&nbsp;</span></p>
<ul>
<li><span style="font-size: 14pt;">The order of characters is a, b, c, d, e, f, g, h, i, j, k, l, m, n, <strong>ng</strong>, o, p, q, r, s, t, u, v, w, x, y, z. </span></li>
<li><span style="font-size: 14pt;">Return <strong>0</strong> if both the strings are equal, <strong>1</strong> if s1 is greater than s2, and <strong>-1</strong> if s1 is lesser than s2.</span></li>
</ul>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input:</strong> s1 = "adding", s2 = "addio"
<strong>Output:</strong> -1
<strong>Explanation:</strong> 'o' has greater priority than 'ng'</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input:</strong> s1 = "abcng", s2 = "abcno"
<strong>Output:</strong> 1
<strong>Explanation:</strong> 'ng' has greater priority than 'n'</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong></span><br><span style="font-size: 14pt;">1 ≤ |s1|, |s2| ≤ 10<sup>5</sup></span><br><span style="font-size: 14pt;">The string contains lower case English alphabets</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;