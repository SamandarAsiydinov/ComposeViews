package com.example.composeviews.util

object Objects {
    const val json1 =  """ {
                button1: { 
                  width: "spread",
                  height: 60,
                  start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['parent', 'top', 16]
                },
                button2: { 
                  width: "spread",
                  height: 60,
                  start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['button1', 'bottom', 16]
                },
                button3: { 
                  width: "spread",
                  height: 60,
                  start: ['parent', 'start', 16],
                  end: ['parent', 'end', 16],
                  top: ['button2', 'bottom', 16]
                }
            } """

    const val json2 =  """ {
                button1: { 
                  width: 100,
                  height: 60,
                  start: ['parent', 'start', 16],
                  end: ['button2', 'start', 16]
                },
                button2: { 
                  width: 100,
                  height: 60,
                  start: ['button1', 'end', 16],
                  end: ['button2', 'start', 16]
                },
                button3: { 
                  width: 100,
                  height: 60,
                  start: ['button2', 'end', 16],
                  end: ['parent', 'end', 16]
                }
            } """
}