import React, { useState, useEffect } from 'react'
import createPlugin, { usePlugin } from 'nekomaid'
import Card from '@material-ui/core/Card'
import CardHeader from '@material-ui/core/CardHeader'
import Toolbar from '@material-ui/core/Toolbar'
import CardContent from '@material-ui/core/CardContent'
import Announcement from '@material-ui/icons/Announcement'

const MOTD: React.FC = () => {
  const plugin = usePlugin()
  const [motd, setMOTD] = useState('')
  useEffect(() => { plugin.emit('motd', setMOTD) }, [])
  return <>
    <Toolbar />
    <Card sx={{ margin: 3 }}>
      <CardHeader title='MOTD' />
      <CardContent>{motd}</CardContent>
    </Card>
  </>
}

createPlugin('ExamplePlugin').addPages({
  title: 'MOTD',
  icon: <Announcement />,
  path: 'motd',
  component: MOTD
})
