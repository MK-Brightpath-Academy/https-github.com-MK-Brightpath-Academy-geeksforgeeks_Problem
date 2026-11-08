<h2><a href="https://www.geeksforgeeks.org/problems/number-following-a-pattern3126/1">Form Number using Pattern</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 14pt;">Given a string <strong>p</strong> consisting only of the characters 'I' and 'D', construct the smallest number that follows the given pattern using digits from 1 to 9, where each digit is used at most once.</span></p>
<ul>
<li><span style="font-size: 14pt;">'I' indicates that the next digit should be greater than the current digit.</span></li>
<li><span style="font-size: 14pt;">'D' indicates that the next digit should be smaller than the current digit.</span></li>
</ul>
<p><span style="font-size: 14pt;">Return the smallest number that satisfies the entire pattern.</span></p>
<p><strong><span style="font-size: 18px;">Examples:</span></strong></p>
<pre><strong><span style="font-size: 18px;">Input: </span></strong><span style="font-size: 18px;">p = "D"</span>
<strong><span style="font-size: 18px;">Output:</span> </strong><span style="font-size: 18px;">"21"</span><strong>
<span style="font-size: 18px;">Explanation: </span></strong><span style="font-size: 18px;">'D' represents decreasing order, so the first digit must be greater than the second digit. Among all possible numbers like 21, 31, 54, and 87, the smallest valid number is 21.</span></pre>
<pre><strong><span style="font-size: 18px;">Input: </span></strong><span style="font-size: 18px;">p = "</span><span style="font-size: 18px;">IIDDD"</span>
<strong><span style="font-size: 18px;">Output:</span> </strong><span style="font-size: 18px;">"126543"</span>
<strong><span style="font-size: 18px;">Explanation: </span></strong><span style="font-size: 18px;">The smallest number satisfying the pattern is: 1 &lt; 2 &lt; 6 &gt; 5 &gt; 4 &gt; 3, which follows the pattern: I - I - D - D - D</span></pre></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<code>Goldman Sachs</code>&nbsp;<code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;