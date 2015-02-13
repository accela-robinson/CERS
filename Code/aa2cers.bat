@echo off
title  Export AA to CME
setlocal
call av-env.cmd
java com.accela.adapter.service.impl.InspectionService 1 2
popd
rem pause
endlocal
		