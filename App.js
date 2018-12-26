/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';
import { Scene, Router, Actions } from 'react-native-router-flux';
import Page1 from './src/Page1'
import Page2 from './src/Page2'
import Page3 from './src/Page3'

const App = () =>{
   return (
    <Router>
      <Scene key="root">
        <Scene
          key="one"
          component={Page1}
          title="PageOne"
          initial={true}
        />
        <Scene key="two" component={Page2} title="PageTwo" />
        <Scene key="three" component={Page3} title="PageThree" />
      </Scene>
    </Router>
  );
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

export default App;
