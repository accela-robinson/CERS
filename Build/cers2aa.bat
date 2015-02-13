@echo off
title Import CME to AA
setlocal
call av-env.cmd
java com.accela.adapter.service.impl.CapService 1 2
popd
rem pause
endlocal
		