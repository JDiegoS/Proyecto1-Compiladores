import PyQt5.QtWidgets as qtw
import PyQt5.QtGui as qtg
from Compiler import Compiler, MyVisitor, MyListener

class MainWindow(qtw.QWidget):

    def __init__(self, file, errors):
        super().__init__()

        self.errors = errors

        # text_edit = qtw.QPlainTextEdit()
        text=open(file).read()
        # text_edit.setPlainText(text)

        # Title
        self.setWindowTitle("Proyecto 01")

        self.setFixedWidth(1400)
        self.setFixedHeight(900)

        # Vertical Layout
        self.setLayout(qtw.QVBoxLayout())

        # Label
        self.label_1 = qtw.QLabel(file, self)

        self.layout().addWidget(self.label_1)

        # Spin Box
        self.my_text =  qtw.QTextEdit(self,
            lineWrapMode=qtw.QTextEdit.setFixedWidth,
            lineWrapColumnOrWidth=50,
            placeholderText="Ingresa el codigo...",
            readOnly=False,
        )

        self.my_text.setPlainText(text)

        self.layout().addWidget(self.my_text)

        # Button
        self.my_button = qtw.QPushButton("Compilar", clicked = lambda: compilar())
        
        self.layout().addWidget(self.my_button)

        # Label
        self.label_2 = qtw.QLabel("Consola\n\n\n\n\n\n\n\n\n\n\n", self)
        f = self.label_2.font()
        f.setPointSize(13)
        self.label_1.setFont(f)
        self.my_text.setFont(f)
        self.my_button.setFont(f)
        self.label_2.setFont(f)

        self.layout().addWidget(self.label_2)

        def compilar():
            f = open(file, "w")
            f.write(self.my_text.toPlainText())
            f.close()
            compiler = Compiler()
            compiler.compile(file)
            errorText = 'Consola\n'
            for i in compiler.errors:
                errorText += i + '\n'
            self.label_2.setText(errorText)

        def getText():
            return self.my_text.toPlainText()


        self.show()

app = qtw.QApplication([])
mw = MainWindow('test2.cl', ['Error1', 'Error2'])

# run
app.exec_()