import os
import glob

#Quitar archivos generados

files = glob.glob('*.java', recursive=True)
files += glob.glob('*.tokens', recursive=True)
files += glob.glob('*.class', recursive=True)
files += glob.glob('*.interp', recursive=True)
files += glob.glob('Parser*.py', recursive=True)

for f in files:
    try:
        os.remove(f)
    except OSError as e:
        print("Error: %s : %s" % (f, e.strerror))