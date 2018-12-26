import React, {Component} from 'react';
import {DeviceEventEmitter, Platform, StyleSheet, Text, View, Button} from 'react-native';
import { Actions } from 'react-native-router-flux';

export default class Page1 extends Component {
  constructor(props){
    super(props);
    this.state = { 
      data: "你好！Page2",
    };
  }

  componentWillMount() {
    
  }

  componentDidMount() {
    
  }

  componentWillReceiveProps(nextProps) {
     this.setState({
      //key : value
     });
 }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>I am PageOne</Text>
        <Text style = {styles.net} onPress = {() => Actions.two({data:this.state.data})}>页面跳转</Text>
        <Text style = {styles.net} onPress = {() => Actions.three()}>网络请求</Text>
      </View>
    );   
  }
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
    margin: 30,
  },
  net: {
    fontSize: 40,
    color: '#00ff00',
    textAlign: 'center',
    marginTop: 20,
  },
});
