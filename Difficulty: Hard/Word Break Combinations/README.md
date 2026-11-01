<h2><a href="https://www.geeksforgeeks.org/problems/word-break-part-23249/1">Word Break Combinations</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18.6667px;">Given a string s and an array of strings dict[] containing valid words, return all possible sentences that can be formed by adding spaces in s such that:</span></p><ul><li><span style="font-size: 18.6667px;">Every word of the sentence is present in dict[]. </span></li><li><span style="font-size: 18.6667px;">A word of dict[] can be used any number of times.&nbsp;</span></li></ul><p><span style="font-size: 18.6667px;">Return the sentences in any order, and return an empty list if no sentence is possible.</span></p><p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p><pre><span style="font-size: 18.6667px;"><strong>Input: </strong>s = "likegfg", dict[] = ["lik", "like", "egfg", "gfg"]<strong>
Output: </strong>["lik egfg", "like gfg"]<strong>
Explanation:</strong>
"likegfg" can be split as "lik" + "egfg", and both words are in the dictionary.
It can also be split as "like" + "gfg", and both words are in the dictionary.
No other split works. For example, after "lik" the rest is "egfg", which can only be matched by the single word "egfg", and after "like" the rest is "gfg", which can only be matched by "gfg".</span></pre><pre><span style="font-size: 14pt;"><span style="font-size: 18.6667px;"><strong>Input: </strong>s = "geeksforgeeks", dict[] = ["for", "geeks"]<strong>
Output: </strong>["geeks for geeks"]<strong>
Explanation: </strong>
"geeksforgeeks" starts with "geeks", then "for" follows, then "geeks" again. 
The word "geeks" is used twice, which is allowed. This is the only valid way to split the string.</span></span></pre><pre><span style="font-size: 14pt;"><span style="font-size: 18.6667px;"><strong>Input:</strong> s = "aaa", dict[] = ["a", "aa"]
<strong>Output:</strong> ["a a a", "a aa", "aa a"]
<strong>Explanation:</strong>
"a a a" uses the word "a" three times.
"a aa" uses "a" followed by "aa".
"aa a" uses "aa" followed by "a".
The whole string "aaa" is not in the dictionary, so it cannot be used as a single word.</span></span></pre></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Google</code>&nbsp;<code>IBM</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Recursion</code>&nbsp;<code>Backtracking</code>&nbsp;<code>Hash</code>&nbsp;