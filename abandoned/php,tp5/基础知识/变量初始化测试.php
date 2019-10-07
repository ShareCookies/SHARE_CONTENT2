<?php
$a = '';
$a['c'] = '';
if (!isset($a)) echo '$a 未被初始化' . "";
if (!isset($b)) echo '$b 未被初始化' . "";
if (isset($a['c'])) echo '$a 已经被初始化' . "";
// 显示结果为
// $b 未被初始化
// $a 已经被初始化
?>