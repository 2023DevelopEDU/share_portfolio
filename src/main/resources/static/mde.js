function customMarkdownParser(plainText) {
    return marked.parse(plainText);
}
var simplemde = new SimpleMDE({
    autofocus: true,
    autosave: {
        enabled: true,
        uniqueId: "MyUniqueID",
        delay: 1000,
    },
    blockStyles: {
        bold: "__",
        italic: "_"
    },
    element: document.getElementById("MyID"),
    forceSync: true,
    indentWithTabs: false,
    initialValue: "Hello world!",
    insertTexts: {
        horizontalRule: ["", "\n\n-----\n\n"],
        image: ["![](http://", ")"],
        link: ["[", "](https://)"],
        table: ["", "\n\n| Column 1 | Column 2 | Column 3 |\n| -------- | -------- | -------- |\n| Text     | Text      | Text     |\n\n"],
    },
    lineWrapping: false,
    parsingConfig: {
        allowAtxHeaderWithoutSpace: true,
        strikethrough: false,
        underscoresBreakWords: true,
    },
    placeholder: "Type here...",

    previewRender: function (plainText, preview) {
        preview.innerHTML = customMarkdownParser(plainText);
        return preview.innerHTML;
    },

    promptURLs: true,
    renderingConfig: {
        singleLineBreaks: false,
        codeSyntaxHighlighting: true,
    },
    shortcuts: {
        drawTable: "Cmd-Alt-T"
    },
    showIcons: ["code", "table"],
    spellChecker: false,
    //status: ["autosave", "lines", "words", "cursor"], // Optional usage
    status: ["autosave", "lines", "words", "cursor", {
        className: "keystrokes",
        defaultValue: function (el) {
            this.keystrokes = 0;
            el.innerHTML = "0 Keystrokes";
        },
        onUpdate: function (el) {
            el.innerHTML = ++this.keystrokes + " Keystrokes";
        }
    }], // Another optional usage, with a custom status bar item that counts keystrokes
    styleSelectedText: false,
    tabSize: 4,
    toolbarTips: false,
    toolbar: ["bold", "italic", "heading", "|", "quote", "unordered-list", "ordered-list",
        "|", {
            name: "link",
            action: function customFunction(editor) {
                var cm = editor.codemirror;
                var selection = cm.getSelection();
                var url = prompt('Enter the URL');
                cm.replaceSelection('[' + selection + '](https://' + url + ')');
            },
            className: "fa fa-link",
            title: "Custom Link",
        }, "image", "|", "preview", "side-by-side", "fullscreen", "|", "guide"],
});
document.querySelector('form').addEventListener('submit', function () {
    document.getElementById('MyID').value = simplemde.value();
});

//이미지 삽입 함수
function insertImage() {
    var input = document.getElementById('imageInput');
    var file = input.files[0];
    var formData = new FormData();
    formData.append('image', file);

    fetch('/upload', {
        method: 'POST',
        body: formData
    })
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            var cm = simplemde.codemirror;
            var output = '![](' + data.url + ')';
            cm.replaceSelection(output);
        })
        .catch(function (error) {
            console.error(error);
        });
}
const convertedContent = content.replace(/\n/g, '<br>');
