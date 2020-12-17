@echo off

for /d %%d in (*) do (
  for %%f in (%%d\*.json) do (
    echo %%f
    mongoimport --db world --collection factbook --file %%f
  )
)
