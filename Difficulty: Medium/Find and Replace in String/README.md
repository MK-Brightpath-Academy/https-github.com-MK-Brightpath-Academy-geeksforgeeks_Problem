<h2><a href="https://www.geeksforgeeks.org/problems/find-an-replace-in-string/1?page=13&category=Arrays%2CStrings%2CJava%2CLinked%20List&company=Amazon%2CMicrosoft%2CGoogle%2CFlipkart&sortBy=submissions">Find and Replace in String</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given a string<strong> s</strong>, an integer array <strong>idx[]</strong>, and two string arrays <strong>src[]</strong> and <strong>tar[]</strong>, consider the following operations on <strong>s</strong>.</span></p>
<ul>
<li><span style="font-size: 18px;">If the substring of <strong>s</strong> starting at index</span><strong style="font-size: 18px;"> </strong><span style="font-size: 18px;"><strong>idx[i]</strong><span style="font-size: 18px;">&nbsp;</span> matches <strong>src[i]</strong> replace it with </span><strong><span style="font-size: 18px;">tar[i]</span></strong><span style="font-size: 18px;">, otherwise, leave s unchanged. </span></li>
<li><span style="font-size: 18px;">These replacements need to be done in one go, no replacements should overlap or performed one after the other.</span></li>
</ul>
<p><span style="font-size: 18px;">Return the string after all valid replacements have been applied simultaneously.</span></p>
<p><span style="font-size: 18px;"><strong>Examples :</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input</strong>: s = "gforks", idx[] = [0, 4], src[] = ["g", "ks"], tar[] = ["geeks", "geeks"]
<strong>Output</strong>: geeksforgeeks
<strong>Explanation</strong>: "g" starts at index 0, so, it's replaced by "geeks". <br>Similarly, "ks" starts at index 4, and is replaced by "geeks".</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input</strong>: s = "gforks", idx[] = [0, 3], src[] = ["g", "ss"], tar[] = ["geeks", "geeks"]
<strong>Output</strong>: geeksforks
<strong>Explanation</strong>: "g" starts at index 0, so, it's replaced by "geeks".<br>"ss" doesn't start at index 3 in original s<strong>, </strong>so it's not replaced.</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong></span><br><span style="font-size: 18px;">1 ≤ |s| ≤ 10<sup>4</sup><br>k == src.size() == tar.size()<br></span><span style="font-size: 18px;">1 ≤ k ≤ 100&nbsp;&nbsp;<br>1 ≤ src[i].size(), tar[i].size() ≤ 50</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;